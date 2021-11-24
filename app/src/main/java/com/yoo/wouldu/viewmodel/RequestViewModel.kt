package com.yoo.wouldu.viewmodel

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yoo.wouldu.Event
import com.yoo.wouldu.model.RequestRepository
import com.yoo.wouldu.model.data.request.How
import com.yoo.wouldu.model.data.request.Request
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RequestViewModel(private val repository: RequestRepository) : ViewModel() {
    private val TAG = "RequestViewModel"

    var _item = MutableLiveData<Request>()
    val item : LiveData<Request> = _item

    private var _requestList = MutableLiveData<List<Request>>()
    val requestList: LiveData<List<Request>> = _requestList

    private val _newTaskEvent = MutableLiveData<Event<Request>>()
    val newTaskEvent: LiveData<Event<Request>> = _newTaskEvent

    private val _closeTaskEvent = MutableLiveData<Event<Unit>>()
    val closeTaskEvent: LiveData<Event<Unit>> = _closeTaskEvent

    private val _startChatEvent = MutableLiveData<Event<Int>>()
    val startChatEvent: LiveData<Event<Int>> = _startChatEvent

    private val _addRequestEvent = MutableLiveData<Event<How>>()
    val addRequestEvent: LiveData<Event<How>> = _addRequestEvent

    fun loadAll() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                _requestList.value = repository.dummy
            }
        }
    }

    fun loadDoCategory() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                _requestList.value = repository.dummy.filter { it.how == How.DO }
            }
        }
    }

    fun loadBuyCategory() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                _requestList.value = repository.dummy.filter { it.how == How.BUY }
            }
        }
    }

    fun loadLendCategory() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                _requestList.value = repository.dummy.filter { it.how == How.LEND }
            }
        }
    }

    fun addNewTask(request: Request) {
        _newTaskEvent.value = Event(request)
    }

    fun addNewTask() {
        _closeTaskEvent.postValue(Event(Unit))
    }

    fun addNewTask(int: Int) {
        Log.d(TAG, "add")
        when (int) {
            0 -> _addRequestEvent.postValue(Event(How.DO))
            1 -> _addRequestEvent.postValue(Event(How.BUY))
            2 -> _addRequestEvent.postValue(Event(How.LEND))
        }
    }

}
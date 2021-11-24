package com.yoo.wouldu.viewmodel

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

//    private val _newTaskEvent = MutableLiveData<Event<Unit>>()
//    val newTaskEvent: LiveData<Event<Unit>> = _newTaskEvent

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

//    fun onBtnExitClick() {
//        _newTaskEvent.postValue(Event(Unit))
//    }

}
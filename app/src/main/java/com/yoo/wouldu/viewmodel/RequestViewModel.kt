package com.yoo.wouldu.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yoo.wouldu.model.RequestRepository
import com.yoo.wouldu.model.data.How
import com.yoo.wouldu.model.data.Request
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RequestViewModel(private val repository: RequestRepository) : ViewModel() {
    private val TAG = "RequestViewModel"

    private var _requestList = MutableLiveData<List<Request>>()
    val requestList: LiveData<List<Request>> = _requestList

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

}
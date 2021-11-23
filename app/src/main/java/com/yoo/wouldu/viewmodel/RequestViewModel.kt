package com.yoo.wouldu.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yoo.wouldu.model.RequestRepository
import com.yoo.wouldu.model.data.Request

class RequestViewModel(private val repository: RequestRepository) : ViewModel() {
    private val TAG = "RequestViewModel"

    val itemList: LiveData<List<Request>> = repository.dummy.asLiveData()

}
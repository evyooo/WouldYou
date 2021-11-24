package com.yoo.wouldu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoo.wouldu.Event
import com.yoo.wouldu.model.AddRepository
import com.yoo.wouldu.model.data.request.Request

class AddViewModel(private val repository: AddRepository) : ViewModel() {
    private val TAG = "AddViewModel"

    private val _newTaskEvent = MutableLiveData<Event<Unit>>()
    val newTaskEvent: LiveData<Event<Unit>> = _newTaskEvent

    fun addNewTask() {
        _newTaskEvent.postValue(Event(Unit))
    }
}
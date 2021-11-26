package com.yoo.wouldu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoo.wouldu.Event
import com.yoo.wouldu.model.AddRepository
import com.yoo.wouldu.model.data.request.Request

class AddViewModel(private val repository: AddRepository) : ViewModel() {
    private val TAG = "AddViewModel"

    private val _keyboardDownEvent = MutableLiveData<Event<Unit>>()
    val keyboardDownEvent: LiveData<Event<Unit>> = _keyboardDownEvent

    private val _closeTaskEvent = MutableLiveData<Event<Unit>>()
    val closeTaskEvent: LiveData<Event<Unit>> = _closeTaskEvent

    private val _startTaskEvent = MutableLiveData<Int>()
    val startTaskEvent: LiveData<Int> = _startTaskEvent

    fun closeNewTask() {
        _closeTaskEvent.postValue(Event(Unit))
    }

    fun startNewTask(int: Int) {
        _startTaskEvent.value = int
    }

    fun keyboardDown() {
        _keyboardDownEvent.postValue(Event(Unit))
    }
}
package com.yoo.wouldu.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoo.wouldu.Event
import com.yoo.wouldu.model.AddRepository

class AddViewModel(private val repository: AddRepository) : ViewModel() {
    private val TAG = "AddViewModel"

    var _what = MutableLiveData<String>()
    val what: LiveData<String> = _what

    var _whatCount = MutableLiveData<Int>()
    val whatCount: LiveData<Int> = _whatCount

    var _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    var _messageCount = MutableLiveData<Int>()
    val messageCount: LiveData<Int> = _messageCount

    private val _keyboardDownEvent = MutableLiveData<Event<Unit>>()
    val keyboardDownEvent: LiveData<Event<Unit>> = _keyboardDownEvent

    private val _closeTaskEvent = MutableLiveData<Event<Unit>>()
    val closeTaskEvent: LiveData<Event<Unit>> = _closeTaskEvent

    private val _startTaskEvent = MutableLiveData<Int>()
    val startTaskEvent: LiveData<Int> = _startTaskEvent

    init {
        _what.postValue("무엇")
        _whatCount.postValue(0)

        _message.postValue("")
        _messageCount.postValue(0)
    }

    fun closeNewTask() {
        _closeTaskEvent.postValue(Event(Unit))
    }

    fun startNewTask(int: Int) {
        _startTaskEvent.value = int
    }

    fun keyboardDown() {
        _keyboardDownEvent.postValue(Event(Unit))
    }

    fun onWhatTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _what.value = s.toString()
        _whatCount.value = what.value?.length
    }

    fun onMessageTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _message.value = s.toString()
        _messageCount.value = message.value?.length
    }
}
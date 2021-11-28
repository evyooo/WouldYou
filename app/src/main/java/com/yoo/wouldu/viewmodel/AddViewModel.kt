package com.yoo.wouldu.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoo.wouldu.Event
import com.yoo.wouldu.model.AddRepository
import com.yoo.wouldu.model.data.request.How

class AddViewModel(private val repository: AddRepository) : ViewModel() {
    private val TAG = "AddViewModel"

    var _how = MutableLiveData<How>()
    var how: LiveData<How> = _how

    var _what = MutableLiveData<String>()
    val what: LiveData<String> = _what
    var _whatCount = MutableLiveData<Int>()
    val whatCount: LiveData<Int> = _whatCount
    var _whatDone = MutableLiveData<Boolean>()
    val whatDone: LiveData<Boolean> = _whatDone

    var _where = MutableLiveData<String>()
    val where: LiveData<String> = _where
    var _whereDetail = MutableLiveData<String>()
    val whereDetail: LiveData<String> = _whereDetail
    var _whereDone = MutableLiveData<Boolean>()
    val whereDone: LiveData<Boolean> = _whereDone

    var _payAmount = MutableLiveData<String>()
    var payAmount: LiveData<String> = _payAmount


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

        _where.postValue("교내 건물")
        _whereDetail.postValue("여기")

        _payAmount.postValue("")

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
        _whatDone.value = whatCount.value != 0
    }

    fun onWhereTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _where.value = s.toString()
        _whereDone.value = where.value?.length != 0 && whereDetail.value?.length != 0
    }

    fun onWhereDetailTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _whereDetail.value = s.toString()
        _whereDone.value = where.value?.length != 0 && whereDetail.value?.length != 0
    }

    fun onAmountTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _payAmount.value = s.toString()
    }

    fun onYearChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _what.value = s.toString()
        _whatCount.value = what.value?.length
        _whatDone.value = whatCount.value != 0
    }

    fun onMessageTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _message.value = s.toString()
        _messageCount.value = message.value?.length
    }
}
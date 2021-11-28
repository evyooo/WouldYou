package com.yoo.wouldu.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoo.wouldu.Event
import com.yoo.wouldu.model.ChatRepository
import com.yoo.wouldu.model.data.chat.Chat
import com.yoo.wouldu.model.data.chat.ChatPreview
import com.yoo.wouldu.model.data.request.Request
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatViewModel(private val repository: ChatRepository): ViewModel() {
    private val TAG = "ChatViewModel"

    private var _previewList = MutableLiveData<List<ChatPreview>>()
    val previewList: LiveData<List<ChatPreview>> = _previewList

    private var _chatList = MutableLiveData<List<Chat>>()
    val chatList: LiveData<List<Chat>> = _chatList

    var _requestInfo = MutableLiveData<Request>()
    val requestInfo: LiveData<Request> = _requestInfo

    // TODO cid만 넘겨주기 (바뀔수도 있음)
    private val _newTaskEvent = MutableLiveData<Event<String>>()
    val newTaskEvent: LiveData<Event<String>> = _newTaskEvent

    private val _closeTaskEvent = MutableLiveData<Event<Unit>>()
    val closeTaskEvent: LiveData<Event<Unit>> = _closeTaskEvent

    fun loadPreview() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                _previewList.value = repository.dummy
            }
        }
    }

    fun loadChat(cid: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                _chatList.value = repository.dummyList[cid]
            }
        }
    }

    fun addNewTask(cid: String) {
        _newTaskEvent.value = Event(cid)
    }

    fun addNewTask() {
        _closeTaskEvent.postValue(Event(Unit))
    }
}
package com.yoo.wouldu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoo.wouldu.Event
import com.yoo.wouldu.model.ChatRepository
import com.yoo.wouldu.model.data.chat.ChatPreview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatViewModel(private val repository: ChatRepository): ViewModel() {
    private val TAG = "ChatViewModel"

    private var _previewList = MutableLiveData<List<ChatPreview>>()
    val previewList: LiveData<List<ChatPreview>> = _previewList

    // TODO cid만 넘겨주기 (바뀔수도 있음)
    private val _newTaskEvent = MutableLiveData<Event<String>>()
    val newTaskEvent: LiveData<Event<String>> = _newTaskEvent

    fun loadPreview() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                _previewList.value = repository.dummy
            }
        }
    }

    fun addNewTask(cid: String) {
        _newTaskEvent.value = Event(cid)
    }
}
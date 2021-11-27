package com.yoo.wouldu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.ActivityChatBinding
import com.yoo.wouldu.databinding.ActivityMainBinding
import com.yoo.wouldu.viewmodel.ChatAdapter
import com.yoo.wouldu.viewmodel.ChatViewModel
import com.yoo.wouldu.viewmodel.PreviewAdapter
import com.yoo.wouldu.viewmodel.RequestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private val chatViewModel: ChatViewModel by viewModel()
    private lateinit var adapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        binding.lifecycleOwner = this
        setObserver()
        binding.viewModel = chatViewModel

        adapter = ChatAdapter(chatViewModel)
        binding.chatRvChat.adapter = adapter
        chatViewModel.loadChat()

    }

    private fun setObserver() {
        chatViewModel.closeTaskEvent.observe(this, Observer {
            onBackPressed()
        })
        chatViewModel.chatList.observe(this, Observer {
            adapter.loadData(it)
        })
    }
}
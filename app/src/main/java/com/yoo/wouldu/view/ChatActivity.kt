package com.yoo.wouldu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.ActivityChatBinding
import com.yoo.wouldu.databinding.ActivityMainBinding
import com.yoo.wouldu.viewmodel.ChatViewModel
import com.yoo.wouldu.viewmodel.RequestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private val chatViewModel: ChatViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        binding.lifecycleOwner = this
        setObserver()

        binding.viewModel = chatViewModel
    }

    private fun setObserver() {
        chatViewModel.closeTaskEvent.observe(this, Observer {
            onBackPressed()
        })
    }
}
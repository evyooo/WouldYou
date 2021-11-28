package com.yoo.wouldu.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.ActivityChatBinding
import com.yoo.wouldu.databinding.ActivityMainBinding
import com.yoo.wouldu.model.data.request.How
import com.yoo.wouldu.model.data.request.Pay
import com.yoo.wouldu.model.data.request.Request
import com.yoo.wouldu.model.data.request.Status
import com.yoo.wouldu.viewmodel.ChatAdapter
import com.yoo.wouldu.viewmodel.ChatViewModel
import com.yoo.wouldu.viewmodel.PreviewAdapter
import com.yoo.wouldu.viewmodel.RequestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDateTime

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

        val isNew = intent.getBooleanExtra("isNew", false)
        if (isNew) {
            val request = intent.getParcelableExtra<Request>("request")
            chatViewModel._requestInfo.value = request
        }
        else {
            val cid = intent.getStringExtra("cid")
            // dummy
            chatViewModel._requestInfo.value = Request(
                "1",
                "공차 초코 밀크티 사다주세요",
                How.BUY,
                "경영대",
                "dd",
                LocalDateTime.of(2021, 3, 1, 12, 30),
                Pay.MONEY,
                "7000원",
                "",
                "햄찌",
                "17학번",
                "여자",
                LocalDateTime.of(2021, 3, 1, 12, 0),
                Status.ACTIVE
            )
            chatViewModel.loadChat(cid!!.toInt())
        }
    }

    private fun setObserver() {
        chatViewModel.closeTaskEvent.observe(this, Observer {
            onBackPressed()
        })
        chatViewModel.chatList.observe(this, Observer {
            adapter.loadData(it)
        })
        chatViewModel.requestInfo.observe(this, Observer {
            binding.request = it
        })
        chatViewModel.reviewEvent.observe(this, Observer {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        })
    }
}
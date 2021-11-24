package com.yoo.wouldu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yoo.wouldu.databinding.ActivityChatBinding
import com.yoo.wouldu.databinding.ActivityMainBinding

class ChatActivity : AppCompatActivity() {

    lateinit var binding: ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
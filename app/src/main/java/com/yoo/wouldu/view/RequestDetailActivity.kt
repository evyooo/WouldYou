package com.yoo.wouldu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yoo.wouldu.databinding.ActivityRequestDetailBinding

class RequestDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRequestDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
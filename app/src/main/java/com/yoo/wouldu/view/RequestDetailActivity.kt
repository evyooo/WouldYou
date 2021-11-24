package com.yoo.wouldu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.yoo.wouldu.databinding.ActivityRequestDetailBinding
import com.yoo.wouldu.viewmodel.RequestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RequestDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRequestDetailBinding
    private val requestViewModel: RequestViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()

        requestViewModel._item.value = intent.getParcelableExtra("item")
        binding.viewModel = requestViewModel
//        detailViewModel.checkItem()

    }

    private fun initBinding() {
        binding = ActivityRequestDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding = ActivityRequestDetailBinding.setContentView(this, R.layout.activity_detail)
//        binding.lifecycleOwner = this
    }

    private fun setObserver() {
//        requestViewModel.newTaskEvent.observe(this, Observer {
//            onBackPressed()
//        })
    }
}
package com.yoo.wouldu.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yoo.wouldu.EventObserver
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentRequestDetailBinding
import com.yoo.wouldu.model.data.request.Request
import com.yoo.wouldu.viewmodel.RequestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class RequestDetailFragment(var request: Request) : Fragment() {

    private val TAG = "RequestDetailFragment"

    private lateinit var binding: FragmentRequestDetailBinding
    private val requestViewModel: RequestViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_request_detail, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObserver()
        binding.viewModel = requestViewModel
        binding.request = request
    }

    private fun setObserver() {
        requestViewModel.closeTaskEvent.observe(viewLifecycleOwner, EventObserver {
            (activity as MainActivity).onBackPressed()
        })
//        requestViewModel.orderItem.observe(viewLifecycleOwner, EventObserver {
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("item", it)
//            startActivity(intent)
//        })
    }

}
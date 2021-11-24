package com.yoo.wouldu.view.addrequest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yoo.wouldu.EventObserver
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentAddRequestBinding
import com.yoo.wouldu.databinding.FragmentHomeBinding
import com.yoo.wouldu.view.MainActivity
import com.yoo.wouldu.view.RequestDetailFragment
import com.yoo.wouldu.viewmodel.AddViewModel
import com.yoo.wouldu.viewmodel.RequestAdapter
import com.yoo.wouldu.viewmodel.RequestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddRequestFragment : Fragment() {

    private val TAG = "AddRequestFragment"

    private lateinit var binding: FragmentAddRequestBinding
    private val addViewModel: AddViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_request, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        addViewModel.loadAll()
        setObserver()
        binding.viewModel = addViewModel
    }

    private fun setObserver() {
        addViewModel.newTaskEvent.observe(viewLifecycleOwner, Observer {
            (activity as AddRequestActivity).onBackPressed()
        })
//        addViewModel.newTaskEvent.observe(viewLifecycleOwner, EventObserver {
//            (activity as MainActivity).addFragment(RequestDetailFragment(it))
//        })
    }
}
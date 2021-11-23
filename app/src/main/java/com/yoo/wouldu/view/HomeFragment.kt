package com.yoo.wouldu.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentHomeBinding
import com.yoo.wouldu.viewmodel.RequestAdapter
import com.yoo.wouldu.viewmodel.RequestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"

    private lateinit var binding: FragmentHomeBinding
    private val requestViewModel: RequestViewModel by viewModel()
    lateinit var adapter: RequestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestViewModel.loadAll()
        setObserver()
        binding.viewModel = requestViewModel

        adapter = RequestAdapter(requestViewModel)
        binding.requestlistRvHome.adapter = adapter
    }

    private fun setObserver() {
        requestViewModel.requestList.observe(viewLifecycleOwner, Observer {
            adapter.loadData(it)
        })
    }

    private fun changeCategory() {
        val categoryList = listOf(binding.allBtnMain, binding.doBtnMain, binding.buyBtnMain, binding.lendBtnMain)
        categoryList.forEach {

        }
    }
}
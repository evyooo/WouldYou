package com.yoo.wouldu.view

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
import com.yoo.wouldu.databinding.FragmentHomeBinding
import com.yoo.wouldu.view.addrequest.AddRequestActivity
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
        requestViewModel.newTaskEvent.observe(viewLifecycleOwner, EventObserver {
            (activity as MainActivity).addFragment(RequestDetailFragment(it))
        })
        requestViewModel.addRequestEvent.observe(viewLifecycleOwner, EventObserver {
            val intent = Intent(context, AddRequestActivity::class.java)
            intent.putExtra("how", it)
            startActivity(intent)
        })
        requestViewModel.category.observe(viewLifecycleOwner, Observer {
            changeCategory(it)
        })
    }

    private fun changeCategory(int: Int) {
        val categoryList = listOf(binding.allBtnMain, binding.doBtnMain, binding.buyBtnMain, binding.lendBtnMain)
        val alienList = listOf(binding.alien1IvHome, binding.alien2IvHome, binding.alien3IvHome, binding.alien4IvHome)
        alienList.forEach {
            it.visibility = View.INVISIBLE
        }
        alienList[int].visibility = View.VISIBLE

        categoryList.forEach {
            it.setTextAppearance(R.style.subtitleReg09)
            it.setTextColor(requireContext().getColor(R.color.deactive04))
            it.setBackgroundColor(requireContext().getColor(R.color.transparent))
        }
        categoryList[int].setTextAppearance(R.style.subtitleBold08)
        categoryList[int].setBackgroundResource(R.drawable.shape_rad20_white_stroke)
    }
}
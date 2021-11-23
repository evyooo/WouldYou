package com.yoo.wouldu.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentHomeBinding
import com.yoo.wouldu.viewmodel.RequestAdapter
import com.yoo.wouldu.viewmodel.RequestViewModel


class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"

    private lateinit var binding: FragmentHomeBinding
//    private val requestViewModel: RequestViewModel by viewModel()
    lateinit var adapter: RequestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setObserver()
//        binding.viewModel = favoriteViewModel
//
//        adapter = FavoriteAdapter(favoriteViewModel)
//        binding.rvItemFavorite.adapter = adapter
//    }
//
//    private fun setObserver() {
//        favoriteViewModel.itemList.observe(viewLifecycleOwner, Observer { items ->
//            items.let {
//                adapter.loadData(it)
//            }
//        })
//    }
}
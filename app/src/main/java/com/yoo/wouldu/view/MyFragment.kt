package com.yoo.wouldu.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentHomeBinding
import com.yoo.wouldu.databinding.FragmentMyBinding

class MyFragment : Fragment() {
    private val TAG = "MyFragment"

    private lateinit var binding: FragmentMyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}
package com.yoo.wouldu.view.addrequest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentAddWhenBinding
import com.yoo.wouldu.databinding.FragmentAddWhereBinding
import com.yoo.wouldu.viewmodel.AddViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddWhereFragment : Fragment() {
    private val TAG = "AddWhereFragment"

    private lateinit var binding: FragmentAddWhereBinding
    private val addViewModel: AddViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_where, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        binding.viewModel = addViewModel

    }

    private fun setObserver() {
        addViewModel.closeTaskEvent.observe(viewLifecycleOwner, Observer {
            (activity as AddRequestActivity).onBackPressed()
        })
    }

}
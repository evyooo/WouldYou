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
import com.yoo.wouldu.databinding.FragmentAddWhatBinding
import com.yoo.wouldu.util.KeyBoard
import com.yoo.wouldu.view.MainActivity
import com.yoo.wouldu.view.RequestDetailFragment
import com.yoo.wouldu.viewmodel.AddViewModel
import com.yoo.wouldu.viewmodel.RequestAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddWhatFragment : Fragment() {
    private val TAG = "AddWhatFragment"

    private lateinit var binding: FragmentAddWhatBinding
    private val addViewModel: AddViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_what, container, false)
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
        addViewModel.keyboardDownEvent.observe(viewLifecycleOwner, Observer {
            KeyBoard().hideSoftKeyboard(requireContext(), binding.whatEtWhat)
        })
    }

}
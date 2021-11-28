package com.yoo.wouldu.view.addrequest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentAddWhatBinding
import com.yoo.wouldu.databinding.FragmentAddWhenBinding
import com.yoo.wouldu.viewmodel.AddViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddWhenFragment : Fragment() {
    private val TAG = "AddWhenFragment"

    private lateinit var binding: FragmentAddWhenBinding
    private val addViewModel: AddViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_when, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        binding.viewModel = addViewModel
        setSpinner()
    }

    private fun setObserver() {
        addViewModel.closeTaskEvent.observe(viewLifecycleOwner, Observer {
            (activity as AddRequestActivity).onBackPressed()
        })
    }

    private fun setSpinner() {
        binding.spinnerYear.minValue = 2021
        binding.spinnerYear.maxValue = 2022
        binding.spinnerMonth.minValue = 1
        binding.spinnerMonth.maxValue = 12
        binding.spinnerDay.minValue = 1
        binding.spinnerDay.maxValue = 31

        binding.spinnerAmpm.minValue = 0
        binding.spinnerAmpm.maxValue = 1
        binding.spinnerAmpm.displayedValues = arrayOf("오전", "오후")
        binding.spinnerHour.minValue = 1
        binding.spinnerHour.maxValue = 12
        binding.spinnerMinute.minValue = 0
        binding.spinnerMinute.maxValue = 5
        binding.spinnerMinute.displayedValues = arrayOf("00", "10", "20", "30", "40", "50")
    }
}
package com.yoo.wouldu.view.addrequest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentAddRequestBinding
import com.yoo.wouldu.util.KeyBoard
import com.yoo.wouldu.viewmodel.AddViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddRequestFragment : Fragment() {

    private val TAG = "AddRequestFragment"

    private lateinit var binding: FragmentAddRequestBinding
    val addViewModel: AddViewModel by sharedViewModel()

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
        setObserver()

        binding.viewModel = addViewModel
        binding.how = addViewModel.how.value
    }

    private fun setObserver() {
        addViewModel.closeTaskEvent.observe(viewLifecycleOwner, Observer {
            (activity as AddRequestActivity).onBackPressed()
        })
        addViewModel.startTaskEvent.observe(viewLifecycleOwner) {
            KeyBoard().hideSoftKeyboard(requireContext(), binding.messageEtAdd)
            when (it.toString()) {
                "0" -> (activity as AddRequestActivity).addFragment(AddWhatFragment())
                "1" -> (activity as AddRequestActivity).addFragment(AddWhenFragment())
                "2" -> (activity as AddRequestActivity).addFragment(AddWhereFragment())
                "3" -> (activity as AddRequestActivity).addFragment(AddPayFragment())
            }
        }
        addViewModel.keyboardDownEvent.observe(viewLifecycleOwner, Observer {
            KeyBoard().hideSoftKeyboard(requireContext(), binding.messageEtAdd)
        })
        addViewModel.what.observe(viewLifecycleOwner, Observer {
            binding.what = addViewModel.what.value
        })
    }
}
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
import com.yoo.wouldu.util.KeyBoard
import com.yoo.wouldu.viewmodel.AddViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddWhereFragment : Fragment() {
    private val TAG = "AddWhereFragment"

    private lateinit var binding: FragmentAddWhereBinding
    val addViewModel: AddViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        addViewModel.keyboardDownEvent.observe(viewLifecycleOwner, Observer {
            KeyBoard().hideSoftKeyboard(requireContext(), binding.detailEtWhere)
        })
        addViewModel.whatDone.observe(viewLifecycleOwner, Observer { done ->
            if (done) binding.button4.setBackgroundResource(R.drawable.shape_btn_activate)
            else binding.button4.setBackgroundResource(R.drawable.shape_btn_deactivate)
        })
    }

}
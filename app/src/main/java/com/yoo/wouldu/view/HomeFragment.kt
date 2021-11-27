package com.yoo.wouldu.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.yoo.wouldu.EventObserver
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentHomeBinding
import com.yoo.wouldu.model.data.request.How
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
            showDialog()
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

    private fun showDialog() {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.dialog_selectrequest, null)

        dialog.setContentView(view)
        dialog.show()

        val addDo = view.findViewById<ImageView>(R.id.imageView3)
        val addBuy = view.findViewById<ImageView>(R.id.imageView21)
        val addLend = view.findViewById<ImageView>(R.id.imageView22)

        val list = listOf(addDo, addBuy, addLend)
        val how = listOf(How.DO, How.BUY, How.LEND)

        (0..2).forEach {
            list[it].setOnClickListener { _ ->
                val intent = Intent(context, AddRequestActivity::class.java)
                intent.putExtra("how", how[it])
                startActivity(intent)
                dialog.cancel()
            }
        }
    }
}
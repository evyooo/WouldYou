package com.yoo.wouldu.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yoo.wouldu.EventObserver
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.FragmentChatBinding
import com.yoo.wouldu.viewmodel.PreviewAdapter
import com.yoo.wouldu.viewmodel.ChatViewModel
import com.yoo.wouldu.viewmodel.RequestAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatFragment : Fragment() {
    private val TAG = "ChatFragment"

    private lateinit var binding: FragmentChatBinding
    private val chatViewModel: ChatViewModel by viewModel()
    lateinit var adapter: PreviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatViewModel.loadPreview()
        setObserver()
        binding.viewModel = chatViewModel

        adapter = PreviewAdapter(chatViewModel)
        binding.previewRvChat.adapter = adapter
    }

    private fun setObserver() {
        chatViewModel.previewList.observe(viewLifecycleOwner, Observer {
            adapter.loadData(it)
        })
        chatViewModel.newTaskEvent.observe(viewLifecycleOwner, EventObserver {
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("isNew", false)
            intent.putExtra("cid", it)
            startActivity(intent)
        })
    }
}
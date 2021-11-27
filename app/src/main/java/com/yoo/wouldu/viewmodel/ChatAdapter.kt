package com.yoo.wouldu.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoo.wouldu.databinding.ItemChatBinding
import com.yoo.wouldu.databinding.ItemChatPreviewBinding
import com.yoo.wouldu.model.data.chat.Chat
import com.yoo.wouldu.model.data.chat.ChatPreview

class ChatAdapter(private val viewModel: ChatViewModel) :
    ListAdapter<Chat, ChatAdapter.ChatViewHolder>(ChatDiffCallback()) {

    class ChatViewHolder(private val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(viewModel: ChatViewModel, chat: Chat) {
                binding.viewModel = viewModel
                binding.item = chat
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatViewHolder {
        return ChatViewHolder(
            ItemChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ChatViewHolder,
        position: Int
    ) {
        holder.bind(viewModel, getItem(position))
    }

    fun loadData(chatList: List<Chat>) {
        submitList(chatList)
    }

    class ChatDiffCallback : DiffUtil.ItemCallback<Chat>() {
        override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
            return oldItem.chatId == newItem.chatId
        }

        override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
            return oldItem == newItem
        }
    }
}
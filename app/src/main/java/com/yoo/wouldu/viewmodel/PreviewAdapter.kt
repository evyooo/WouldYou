package com.yoo.wouldu.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoo.wouldu.databinding.ItemChatPreviewBinding
import com.yoo.wouldu.model.data.chat.ChatPreview

class PreviewAdapter(private val viewModel: ChatViewModel) :
    ListAdapter<ChatPreview, PreviewAdapter.ChatViewHolder>(PreviewDiffCallback()) {

    class ChatViewHolder(private val binding: ItemChatPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(viewModel: ChatViewModel, preview: ChatPreview) {
                binding.viewModel = viewModel
                binding.item = preview
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatViewHolder {
        return ChatViewHolder(
            ItemChatPreviewBinding.inflate(
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

    fun loadData(PreviewList: List<ChatPreview>) {
        submitList(PreviewList)
    }


    class PreviewDiffCallback : DiffUtil.ItemCallback<ChatPreview>() {
        override fun areItemsTheSame(oldItem: ChatPreview, newItem: ChatPreview): Boolean {
            return oldItem.chatId == newItem.chatId
        }

        override fun areContentsTheSame(oldItem: ChatPreview, newItem: ChatPreview): Boolean {
            return oldItem == newItem
        }
    }
}
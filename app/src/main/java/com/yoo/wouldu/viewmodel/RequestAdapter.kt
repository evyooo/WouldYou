package com.yoo.wouldu.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.yoo.wouldu.model.data.Request
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yoo.wouldu.databinding.ItemRequestBinding

class RequestAdapter(private val viewModel: RequestViewModel) :
    ListAdapter<Request, RequestAdapter.RequestViewHolder>(RequestDiffCallback()) {

    class RequestViewHolder(private val binding: ItemRequestBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(viewModel: RequestViewModel, request: Request) {
                binding.viewModel = viewModel
                binding.item = request
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RequestViewHolder {
        return RequestViewHolder(
            ItemRequestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: RequestViewHolder,
        position: Int
    ) {
        holder.bind(viewModel, getItem(position))
    }


    class RequestDiffCallback : DiffUtil.ItemCallback<Request>() {
        override fun areItemsTheSame(oldItem: Request, newItem: Request): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Request, newItem: Request): Boolean {
            return oldItem == newItem
        }
    }
}
package com.example.assigment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment.databinding.ItemContactsBinding
import com.example.assigment.db.Contacts

class ContactAdapter: ListAdapter<Contacts, ContactAdapter.ViewHolder>(ContactDiffCallback())  {

    class ViewHolder private constructor(val binding: ItemContactsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Contacts) {
            binding.contact = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemContactsBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
}

class ContactDiffCallback : DiffUtil.ItemCallback<Contacts>() {

    override fun areItemsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
        return oldItem.id == newItem.id
    }


}
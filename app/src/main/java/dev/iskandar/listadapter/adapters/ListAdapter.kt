package dev.iskandar.listadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import dev.iskandar.listadapter.databinding.ItemRvBinding
import dev.iskandar.listadapter.models.User

class MyListAdapter : ListAdapter<User, MyListAdapter.Vh>(MyDiffUtil()) {
    inner class Vh(var itemRvBinding: ItemRvBinding) : ViewHolder(itemRvBinding.root) {
        fun onBind(user: User) {
            itemRvBinding.textName.text = user.name
            itemRvBinding.textNumber.text = user.number
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }
}
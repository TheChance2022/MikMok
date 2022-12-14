package com.example.android.mikmok.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.mikmok.data.model.Item
import com.example.android.mikmok.databinding.CardItemBinding
import com.example.android.mikmok.utils.ExoPlay

class FeedAdapter(
    private var listener: OnClickListener,
    private var items: ArrayList<Item>,
) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    interface OnClickListener {
        fun onClick(item: Item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    fun setData(newItems: ArrayList<Item>) {
        items.clear()
        items.addAll(newItems)
        items = newItems
    }


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemView.tag = position

        holder.binding.apply {
            titleText.text = currentItem.title
            descriptionText.text = currentItem.description
            Glide
                .with(holder.itemView.context)
                .load(currentItem.art)
                .into(imageView)

            shareText.setOnClickListener {
                listener.onClick(currentItem)
            }
        }
    }


    override fun getItemCount() = items.size

    class FeedViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {}
}



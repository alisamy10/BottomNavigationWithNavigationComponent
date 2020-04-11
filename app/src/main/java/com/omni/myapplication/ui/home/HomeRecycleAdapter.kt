package com.example.movieapp.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.omni.myapplication.R
import com.omni.myapplication.data.Model
import kotlinx.android.synthetic.main.home_list_item.view.*

/**
 * Created by ali samy Mohamed on 4/4/2020.
 * alisamymohamed@outlook.com
 */



class HomeRecycleAdapter(private val interaction: OnItemClicked? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Model>() {

        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.title==oldItem.title
        }

        @SuppressLint("DiffUtilEquals")

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return  oldItem==newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_list_item,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Model>?) {
        differ?.submitList(list)
    }

    class HomeViewHolder
    constructor(
        itemView: View,
        private val onClicked: OnItemClicked?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Model) = with (itemView) {



            itemView.item_image.setOnClickListener({
                onClicked?.onPosterSelected(adapterPosition, item)
            })



            itemView.item_tile.text = item.title

        }
    }

    interface OnItemClicked {
        fun onPosterSelected(position: Int, item: Model)

    }
}






package com.example.mystorynew

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystorynew.databinding.StoryItemBinding


class StoryAdapter(private val storyList: List<String>) :
    RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    private var context: Context? = null

    class StoryViewHolder(val binding: StoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        context = parent.context
        var binding: StoryItemBinding? = null





        binding = StoryItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )



        return StoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        storyList[position].let {
            holder.binding.apply {
                Glide.with(context!!).load(it).into(this.imagePager)


            }


        }


    }


}
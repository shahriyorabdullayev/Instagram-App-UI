package com.example.m5_l10instagramui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l10instagramui.R
import com.example.m5_l10instagramui.model.Story
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(val context: Context, val items: ArrayList<Story>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_CREATE = 0
    private val TYPE_ITEM_STORY = 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_ITEM_CREATE
        }
        return TYPE_ITEM_STORY
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_CREATE) {
            return CreateViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_create_story, parent, false))
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder) {
            holder.apply {
                ivProfile.setImageResource(story.profile)
                tvFullname.text = story.fullname
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivProfile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        val tvFullname = view.findViewById<TextView>(R.id.tv_fullname)
    }

    class CreateViewHolder(view:View): RecyclerView.ViewHolder(view){

    }
}
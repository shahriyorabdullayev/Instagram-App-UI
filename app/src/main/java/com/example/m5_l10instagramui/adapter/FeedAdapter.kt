package com.example.m5_l10instagramui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l10instagramui.R
import com.example.m5_l10instagramui.model.Feed
import com.example.m5_l10instagramui.model.Story
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(val context: Context, val items:ArrayList<Feed>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_STORY = 0
    private val TYPE_ITEM_FEED = 1

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]
        if (feed.stories.size > 0){
            return TYPE_ITEM_STORY
        }
        return TYPE_ITEM_FEED
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_STORY) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(view)
        }
        return FeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post,parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is StoryViewHolder) {
            holder.apply {
                rvStory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                refreshAdapter(feed.stories, rvStory)
            }
        }

        if (holder is FeedViewHolder) {
            holder.apply {
                ivProfile.setImageResource(feed.post!!.profile)
                ivPhoto.setImageResource(feed.post!!.photo)
                tvFullname.text = feed.post!!.fullname
            }
        }
    }

    private fun refreshAdapter(stories: ArrayList<Story>, rv: RecyclerView){
        val adapter = StoryAdapter(context, stories)
        rv.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        val ivPhoto = view.findViewById<ImageView>(R.id.iv_post)
        val tvFullname = view.findViewById<TextView>(R.id.tv_fullname)

    }

    class StoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val rvStory = view.findViewById<RecyclerView>(R.id.rv_story)
    }
}
package com.example.m5_l10instagramui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l10instagramui.adapter.FeedAdapter
import com.example.m5_l10instagramui.model.Feed
import com.example.m5_l10instagramui.model.Post
import com.example.m5_l10instagramui.model.Story

class MainActivity : AppCompatActivity() {
    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        rvMain = findViewById(R.id.rv_main)
        rvMain.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllFeeds())

    }

    private fun refreshAdapter(feeds: ArrayList<Feed>){
        val adapter = FeedAdapter(this, feeds)
        rvMain.adapter = adapter
    }

    private fun getAllFeeds() :ArrayList<Feed> {
        val stories = ArrayList<Story>()
        stories.add(Story(R.drawable.im_profile, "Shahriyor"))
        stories.add(Story(R.drawable.im_profile, "Shahriyor"))
        stories.add(Story(R.drawable.im_profile, "Shahriyor"))
        stories.add(Story(R.drawable.im_profile, "Shahriyor"))
        stories.add(Story(R.drawable.im_profile, "Shahriyor"))
        stories.add(Story(R.drawable.im_profile, "Shahriyor"))
        stories.add(Story(R.drawable.im_profile, "Shahriyor"))
        stories.add(Story(R.drawable.im_profile, "Shahriyor"))
        stories.add(Story(R.drawable.im_profile, "Shahriyor"))

        val feeds = ArrayList<Feed>()

        feeds.add(Feed(stories))

        feeds.add(Feed(Post(R.drawable.im_profile, "Shahriyor Abdullayev", R.drawable.im_post)))
        feeds.add(Feed(Post(R.drawable.im_profile, "Shahriyor Abdullayev", R.drawable.im_post)))
        feeds.add(Feed(Post(R.drawable.im_profile, "Shahriyor Abdullayev", R.drawable.im_post)))
        feeds.add(Feed(Post(R.drawable.im_profile, "Shahriyor Abdullayev", R.drawable.im_post)))
        feeds.add(Feed(Post(R.drawable.im_profile, "Shahriyor Abdullayev", R.drawable.im_post)))
        feeds.add(Feed(Post(R.drawable.im_profile, "Shahriyor Abdullayev", R.drawable.im_post)))
        feeds.add(Feed(Post(R.drawable.im_profile, "Shahriyor Abdullayev", R.drawable.im_post)))
        feeds.add(Feed(Post(R.drawable.im_profile, "Shahriyor Abdullayev", R.drawable.im_post)))
        feeds.add(Feed(Post(R.drawable.im_profile, "Shahriyor Abdullayev", R.drawable.im_post)))

        return feeds


    }
}
package com.example.m5_l10instagramui.model

class Feed {

    var post: Post? = null
    var stories: ArrayList<Story> = ArrayList()

    constructor(post: Post?) {
        this.post = post
    }

    constructor(stories: ArrayList<Story>){
        this.stories = stories
    }
}
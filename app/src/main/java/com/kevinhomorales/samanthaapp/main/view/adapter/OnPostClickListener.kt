package com.kevinhomorales.samanthaapp.main.view.adapter

import com.kevinhomorales.samanthaapp.sample.model.posts.PostsItem

interface OnPostClickListener {
    fun postClick(postsItem: PostsItem)
}
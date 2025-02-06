package com.kevinhomorales.samanthaapp.sample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevinhomorales.samanthaapp.networkmanager.RetrofitService
import com.kevinhomorales.samanthaapp.sample.model.posts.PostsItem
import kotlinx.coroutines.launch

class SampleViewModel(private val service: RetrofitService): ViewModel() {

    private val _posts = MutableLiveData<MutableList<PostsItem>>()
    val posts: MutableLiveData<MutableList<PostsItem>> get() = _posts

    fun getPosts() {
        viewModelScope.launch {
            val posts = service.getPosts().toMutableList()
            _posts.value = posts
        }
    }
}
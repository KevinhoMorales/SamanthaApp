package com.kevinhomorales.samanthaapp.sample.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kevinhomorales.samanthaapp.databinding.ActivitySampleBinding
import com.kevinhomorales.samanthaapp.main.view.adapter.ItemAdapter
import com.kevinhomorales.samanthaapp.main.view.adapter.OnPostClickListener
import com.kevinhomorales.samanthaapp.profile.view.ProfileActivity
import com.kevinhomorales.samanthaapp.networkmanager.RetrofitServiceFactory
import com.kevinhomorales.samanthaapp.sample.SampleViewModelFactory
import com.kevinhomorales.samanthaapp.sample.model.posts.PostsItem
import com.kevinhomorales.samanthaapp.sample.viewmodel.SampleViewModel

class SampleActivity : AppCompatActivity(), OnPostClickListener {
    lateinit var binding: ActivitySampleBinding

    lateinit var itemAdapter: ItemAdapter
    private val viewModel: SampleViewModel by viewModels {
        SampleViewModelFactory(RetrofitServiceFactory.makeRetrofitService())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
        observePosts()
    }

    private fun setUpView() {
        setUpActions()
        setUpRecyclerView()
        binding.progressBarId.visibility = View.VISIBLE
    }

    private fun setUpActions() {
        binding.profileIconId.setOnClickListener {
            openProfileView()
        }
    }

    private fun setUpRecyclerView() {
        itemAdapter = ItemAdapter(this)
        binding.recyclerViewId.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewId.adapter = itemAdapter
        viewModel.getPosts()
    }

    private fun observePosts() {
        viewModel.posts.observe(this) { posts ->
            binding.progressBarId.visibility = View.GONE
            itemAdapter.setListData(posts)
            itemAdapter.notifyDataSetChanged()
        }
    }

    private fun openProfileView() {
        val profileIntent = Intent(this, ProfileActivity::class.java)
        startActivity(profileIntent)
    }

    override fun postClick(postsItem: PostsItem) {
        Toast.makeText(this, postsItem.title, Toast.LENGTH_SHORT).show()
    }
}
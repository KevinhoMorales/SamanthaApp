package com.kevinhomorales.samanthaapp.main.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.kevinhomorales.samanthaapp.main.view.adapter.ItemAdapter
import com.kevinhomorales.samanthaapp.main.view.adapter.OnPostClickListener
import com.kevinhomorales.samanthaapp.profile.view.ProfileActivity
import com.kevinhomorales.samanthaapp.networkmanager.RetrofitServiceFactory
import com.kevinhomorales.samanthaapp.databinding.ActivityMainBinding
import com.kevinhomorales.samanthaapp.lottie.AnimationActivity
import com.kevinhomorales.samanthaapp.sample.model.posts.PostsItem
import kotlinx.coroutines.launch

open class MainActivity : AppCompatActivity(), OnPostClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        setUpActions()
//        setLogin()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        itemAdapter = ItemAdapter(this)
        binding.recyclerViewId.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewId.adapter = itemAdapter
        getData()
    }

    private fun setLogin() {
        val email = "kfmorales94@gmail.com"
        val password = "12345678"
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    openProfileView()
                    finish()
                } else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }

        val user = Firebase.auth.currentUser!!
        user.delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }

        Firebase.auth.signInWithEmailAndPassword(email, password)
    }

    private fun setUpActions() {
        binding.profileIconId.setOnClickListener {
            openProfileView()
        }
    }

    private fun openProfileView() {
        val profileIntent = Intent(this, ProfileActivity::class.java)
        startActivity(profileIntent)
    }

    private fun openAnimationView() {
        val animationInten = Intent(this, AnimationActivity::class.java)
        startActivity(animationInten)
    }

    private fun getData() {
        val service = RetrofitServiceFactory.makeRetrofitService()
        lifecycleScope.launch {
            val users = service.getUsers()
            val posts = service.getPosts().toMutableList()
            val comments = service.getComments()
//            val firstUserEmail = users.first().email
//            val names = users.map { it.name }.joinToString(", ")
            binding.informationApiId.setText(posts.first().title)
            var miArreglo = mutableListOf("X", "Facebook")
//            getDataA() { respuestaFinal ->
//                println(respuestaFinal)
//            }
            itemAdapter.setListData(posts)
            itemAdapter.notifyDataSetChanged()
        }
    }

    // CALLBACK
    // COMPLETION HANDLER
    // HANDLER

    // EXPLICACIÓN CONCATENACIÓN DE SERVICIOS Y CALLBACK
//    private fun getDataA(callback: (String) -> Unit) {
//        val response = "Respuesta A"
//        getDataB(response, callback)
//    }
//
//    private fun getDataB(fromA: String, callback: (String) -> Unit) {
//        val response = "Respuesta B"
//        getDataC(response, callback)
//    }
//
//    private fun getDataC(fromB: String, callback: (String) -> Unit) {
//        val response = "Respuesta C"
//        getDataC(response, callback)
//    }
//
//    private fun getDataD0() {
//        val response = "Respuesta D0"
//        getDataD1()
//    }
//
//    private fun getDataD1() {
//        getDataD2()
//    }
//
//    private fun getDataD2() {
//        print("Final!")
//    }

    override fun postClick(postsItem: PostsItem) {
        openAnimationView()
//        Toast.makeText(this, postsItem.title, Toast.LENGTH_SHORT).show()
    }
}
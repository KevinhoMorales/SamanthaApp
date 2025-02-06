package com.kevinhomorales.samanthaapp.lottie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kevinhomorales.samanthaapp.databinding.ActivityAnimationBinding
import com.kevinhomorales.samanthaapp.main.view.MainActivity
import com.kevinhomorales.samanthaapp.profile.view.ProfileActivity

class AnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        setUpAnimation()
    }

    private fun setUpAnimation() {
        binding.animationId.playAnimation()
        binding.animationId.repeatCount = 4
        binding.animationId.postDelayed({
            binding.animationId.cancelAnimation()
            openMainView()
        }, 10000)
    }

    private fun openMainView() {
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
    }
}
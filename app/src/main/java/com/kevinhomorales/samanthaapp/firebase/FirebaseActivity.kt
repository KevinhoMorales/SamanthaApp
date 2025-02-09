package com.kevinhomorales.samanthaapp.firebase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore
import com.kevinhomorales.samanthaapp.R
import com.kevinhomorales.samanthaapp.databinding.ActivityFirebaseBinding

class FirebaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirebaseBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        setUpActions()
//        setUpSampleCrashlytics()
    }

    private fun setUpActions() {
        binding.saveButtonId.setOnClickListener {
            saveUser()
        }
        binding.retrieveButtonId.setOnClickListener {
            getUser()
        }
    }

    private fun saveUser() {
        val user = User("Samantha", 25)
        db.collection("users")
            .document("samantha")
            .set(user)
            .addOnSuccessListener { result ->
                binding.nameAgeTextId.text = "Datos guardados éxitosamente ${result}"
            }
            .addOnFailureListener { error ->
                binding.nameAgeTextId.text = "Error ${error.localizedMessage}"
            }
    }

    private fun getUser() {
        db.collection("users")
            .document("samantha")
            .get()
            .addOnSuccessListener { result ->
                binding.nameAgeTextId.text = "Mi nombre es ${result.get("name")} y tengo ${result.get("age")} años"
            }
            .addOnFailureListener { error ->
                binding.nameAgeTextId.text = "Error ${error.localizedMessage}"
            }
    }

    private fun setUpSampleCrashlytics() {
        throw RuntimeException("Test Crash") // Force a crash
    }
}



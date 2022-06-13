package com.dicoding.capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dicoding.capstone.databinding.ActivitySurveiBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SurveiActivity :AppCompatActivity() {

    private lateinit var binding: ActivitySurveiBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonsurvei.setOnClickListener{

            val favoriteCity = binding.TextFavCity.text.toString()
            val dreamVacation = binding.TextEditSuasana.text.toString()
            val lastVacation = binding.TextLastVac.text.toString()

            database = FirebaseDatabase.getInstance().getReference("User")

            val UserSurvei = UserSurvei(favoriteCity,dreamVacation,lastVacation)
            database.child(dreamVacation).setValue(UserSurvei).addOnSuccessListener {

                binding.TextEditSuasana.text.clear()
                binding.TextFavCity.text.clear()
                binding.Textjobs.text.clear()
                binding.TextDate.text.clear()
                binding.TextEditLongStay.text.clear()
                binding.TextLastVac.text.clear()

                Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this, "Data Not Saved", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
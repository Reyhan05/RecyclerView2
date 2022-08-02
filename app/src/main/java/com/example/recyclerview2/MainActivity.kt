package com.example.recyclerview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview2.databinding.ActivityMainBinding
import com.example.recyclerview2.four.FourActivity
import com.example.recyclerview2.thirdRV.ThirdActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnThird.setOnClickListener{
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        binding.btnHeroesGirls.setOnClickListener {
            startActivity(Intent(this, FourActivity::class.java))
        }
    }
}
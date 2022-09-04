package com.example.chapter3topic1.topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter3topic1.R
import kotlinx.android.synthetic.main.activity_topic1_main.*

class Topic1MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic1_main)

        btnPenjumlahan.setOnClickListener {
            val pindah = Intent(this, PenjumlahanActivity ::class.java)
            startActivity(pindah)
        }

        btnBMI.setOnClickListener{
            val pindah = Intent(this, BmiActivity ::class.java)
            startActivity(pindah)
        }

        btnNilaiAkhir.setOnClickListener{
            val pindah = Intent(this, NilaiAkhirActivity ::class.java)
            startActivity(pindah)
        }
    }
}
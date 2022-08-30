package com.example.chapter3topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPenjumlahan.setOnClickListener {
            var pindah = Intent(this, PenjumlahanActivity ::class.java)
            startActivity(pindah)
        }

        btnBMI.setOnClickListener{
            var pindah = Intent(this, BmiActivity ::class.java)
            startActivity(pindah)
        }

        btnNilaiAkhir.setOnClickListener{
            var pindah = Intent(this, NilaiAkhirActivity ::class.java)
            startActivity(pindah)
        }
    }
}
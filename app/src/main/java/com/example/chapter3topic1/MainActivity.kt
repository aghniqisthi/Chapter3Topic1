package com.example.chapter3topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter3topic1.topic1.Topic1MainActivity
import com.example.chapter3topic1.topic2.Tugas2BmiActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTopic1.setOnClickListener {
            val pindah = Intent(this, Topic1MainActivity ::class.java)
            startActivity(pindah)
        }

        btnTopic2.setOnClickListener{
            val pindah = Intent(this, Tugas2BmiActivity ::class.java)
            startActivity(pindah)
        }
    }
}
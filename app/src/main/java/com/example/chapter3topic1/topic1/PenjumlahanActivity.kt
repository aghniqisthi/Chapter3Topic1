package com.example.chapter3topic1.topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter3topic1.R
import kotlinx.android.synthetic.main.activity_penjumlahan.*
import kotlinx.android.synthetic.main.activity_penjumlahan.btnBack
import kotlinx.android.synthetic.main.activity_penjumlahan.btnReset

class PenjumlahanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjumlahan)

        btnHasil.setOnClickListener{
            val angka1 = editAngka1.text.toString().toInt()
            val angka2 = editAngka2.text.toString().toInt()
            val hasil = angka1 + angka2
            textViewHasil.text = "Hasil $angka1 + $angka2 = $hasil"

            if(hasil > 100) textViewHasilKondisi.text = "Hasil lebih Dari 100"
            else textViewHasilKondisi.text = "Hasil kurang dari 100"
        }

        btnReset.setOnClickListener{
            resetData()
        }

        btnBack.setOnClickListener {
            val pindah = Intent(this, Topic1MainActivity ::class.java)
            startActivity(pindah)
        }
    }

    fun resetData(){
        editAngka1.setText("")
        editAngka2.setText("")
    }
}
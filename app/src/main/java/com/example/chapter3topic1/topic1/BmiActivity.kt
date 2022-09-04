package com.example.chapter3topic1.topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter3topic1.R
import kotlinx.android.synthetic.main.activity_bmi.*

class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        btnHitung.setOnClickListener{
            val tb = editTextTB.text.toString()
            val bb = editTextBB.text.toString()
            val bmi = hitungBMI(bb.toDouble(), tb.toDouble())

            txtUmur.text = "${editTextUmur.text} tahun"
            txtTB.text = "$tb cm"
            txtBB.text = "$bb kg"
            txtBMI.text = String.format("%.3f", bmi)
            txtKategori.text = kategori(bmi)

        }

        btnReset.setOnClickListener{
            reset()
        }

        btnBack.setOnClickListener {
            val pindah = Intent(this, Topic1MainActivity ::class.java)
            startActivity(pindah)
        }
    }

    private fun hitungBMI(berat: Double, tinggi: Double): Double{
        val tb = tinggi / 100
        return berat / (tb*tb)
    }

    private fun kategori(bmi: Double):String{
        val kategori: String
        if (bmi < 16 && bmi > 0) {
            kategori = "Terlalu Kurus"
        } else if (bmi >= 16 && bmi <= 17) {
            kategori = "Cukup Kurus"
        } else if (bmi > 17 && bmi <= 18.5) {
            kategori = "Sedikit Kurus"
        } else if (bmi > 18.5 && bmi <= 25) {
            kategori = "Normal"
        } else if (bmi > 25 && bmi <= 30) {
            kategori = "Gemuk"
        } else if (bmi > 30 && bmi <= 35) {
            kategori = "Obesitas Kelas I"
        } else if (bmi > 35 && bmi <= 40) {
            kategori = "Obesitas Kelas II"
        } else if (bmi > 40) {
            kategori = "Obesitas Kelas III"
        }
        else kategori = "BMI Keluar Ambang Batas"
        return kategori
    }

    private fun reset(){
        txtUmur.text = ""
        txtTB.text = ""
        txtBB.text = ""
        txtBMI.text = ""
        txtKategori.text = ""

        editTextUmur.setText("")
        editTextTB.setText("")
        editTextBB.setText("")
    }

}
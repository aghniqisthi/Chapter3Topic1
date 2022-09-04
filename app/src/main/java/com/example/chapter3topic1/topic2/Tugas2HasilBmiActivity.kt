package com.example.chapter3topic1.topic2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter3topic1.R
import kotlinx.android.synthetic.main.activity_tugas2_hasil_bmi.*

class Tugas2HasilBmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas2_hasil_bmi)

        if(intent.getStringExtra("klikExplicit") == "true"){
            ambilDataBMIExplicitIntent()
        }
        else if(intent.getStringExtra("klikBundle") == "true"){
            ambilDataBMIBundle()
        }
        else if(intent.getStringExtra("klikSer") == "true") {
            ambilDataBMISerializable()
        }
        else ambilDataBMIParcelable()

        btnBack.setOnClickListener {
            val pindah = Intent(this, Tugas2BmiActivity ::class.java)
            startActivity(pindah)
        }
    }

    private fun ambilDataBMIExplicitIntent(){
        val umur =  intent.getStringExtra("umur")
        val tb =  intent.getStringExtra("tb")
        val bb =  intent.getStringExtra("bb")
        val bmi = intent.getStringExtra("bmi")
        val kategori = intent.getStringExtra("kategori")

        txtHasilUmur.text = umur
        txtHasilTB.text = tb
        txtHasilBB.text = bb
        txtHasilBMI.text = bmi
        txtHasilKategori.text = kategori
    }

    private fun ambilDataBMIBundle(){
        val bundle = intent.extras
        txtHasilUmur.setText(bundle?.getString("umur"))
        txtHasilTB.setText(bundle?.getString("tb"))
        txtHasilBB.setText(bundle?.getString("bb"))
        txtHasilBMI.setText(bundle?.getString("bmi"))
        txtHasilKategori.setText(bundle?.getString("kategori"))
    }

    private fun ambilDataBMISerializable(){
        val databmi = intent.getSerializableExtra("databmi") as DataBMISerializable

        txtHasilUmur.text = databmi.umur
        txtHasilTB.text = databmi.tb
        txtHasilBB.text = databmi.bb
        txtHasilBMI.text = databmi.bmi
        txtHasilKategori.text = databmi.kategori
    }

    private fun ambilDataBMIParcelable(){
        val databmi = intent.getParcelableExtra("databmi") as DataBMIParcelable?
        txtHasilUmur.text = databmi?.umur
        txtHasilTB.text = databmi?.tb
        txtHasilBB.text = databmi?.bb
        txtHasilBMI.text = databmi?.bmi
        txtHasilKategori.text = databmi?.kategori
    }
}


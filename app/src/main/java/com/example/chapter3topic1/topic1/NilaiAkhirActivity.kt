package com.example.chapter3topic1.topic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter3topic1.R
import kotlinx.android.synthetic.main.activity_nilai_akhir.*
import kotlinx.android.synthetic.main.activity_nilai_akhir.btnBack
import kotlinx.android.synthetic.main.activity_nilai_akhir.btnHitung
import kotlinx.android.synthetic.main.activity_nilai_akhir.btnReset

class NilaiAkhirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai_akhir)

        btnHitung.setOnClickListener{
            val nama = editTextNama.text.toString()
            val nim = editTextNIM.text.toString()
            val uas = editTextUAS.text.toString()
            val uts = editTextUTS.text.toString()
            val tugas = editTextTugas.text.toString()

            cetakData(nama, nim, uas, uts, tugas)
            cetakNilai(uas.toDouble(), uts.toDouble(), tugas.toDouble())
        }

        btnReset.setOnClickListener {
            editTextNama.setText("")
            editTextNIM.setText("")
            editTextUAS.setText("")
            editTextUTS.setText("")
            editTextTugas.setText("")

            txtNama.text = ""
            txtNIM.text = ""
            txtUAS.text = ""
            txtUTS.text = ""
            txtTugas.text = ""
            txtTotal.text = ""
            txtRataRata.text = ""
            txtNilaiHrf.text = ""
            txtStatus.text = ""
        }

        btnBack.setOnClickListener {
            val pindah = Intent(this, Topic1MainActivity ::class.java)
            startActivity(pindah)
        }
    }

    private fun total(tgs: Double, uts: Double, uas: Double): Double{
        return tgs + uts + uas
    }

    private fun rataRata(total:Double): Double{
        return total/3
    }

    private fun seleksiNilai(ratarata:Double):String{
        if(ratarata in 0.0..60.0) return "F"
        else if(ratarata in 61.0..70.0) return "D"
        else if(ratarata in 71.0..80.0) return "C"
        else if(ratarata in 81.0..90.0) return "B"
        else if(ratarata in 91.0..100.0) return "A"
        else return "Rata-Rata Tidak Valid"
    }

    fun status(nilai:String):String{
        if(nilai == "A" || nilai == "B" || nilai == "C") return "Lulus"
        else return "Tidak Lulus"
    }

    fun cetakData(nama: String, nim: String, uas: String, uts: String, tugas: String){
        txtNama.text = nama
        txtNIM.text = nim
        txtUAS.text = uas
        txtUTS.text = uts
        txtTugas.text = tugas
    }

    fun cetakNilai(uas: Double, uts: Double, tugas: Double){
        if(tugas in 0.0..100.00 && uts in 0.0..100.0 && uas in 0.0..100.0){
            val total = total(tugas, uts, uas)
            val rata = rataRata(total)
            val nilaiHrf = seleksiNilai(rata)

            txtTotal.text = total.toString()
            txtRataRata.text = String.format("%.3f", rata)
            txtNilaiHrf.text = nilaiHrf
            txtStatus.text = status(nilaiHrf)
        }
        else{
            txtTotal.text = "Nilai Melebihi Range"
            txtRataRata.text = "Nilai Melebihi Range"
            txtNilaiHrf.text = "Nilai Melebihi Range"
            txtStatus.text = "Tidak Lulus"
        }
    }
}
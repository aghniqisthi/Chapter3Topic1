package com.example.chapter3topic1.topic2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter3topic1.MainActivity
import com.example.chapter3topic1.R
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlinx.android.synthetic.main.activity_tugas2_bmi.*

class Tugas2BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas2_bmi)

        btnBackBMI.setOnClickListener {
            val pindah = Intent(this, MainActivity ::class.java)
            startActivity(pindah)
        }
        btnResetBMI.setOnClickListener{
            reset()
        }

        //implicit intent (buka web kalkulator)
        btnImplicitIntent.setOnClickListener {
            implicitIntentBMI()
        }

        //explicit intent (buka hasil activity lain pake direct intent)
        btnExplicitIntent.setOnClickListener {
            explicitIntentBMI()
        }

        //bundle (data dibuat bundle)
        btnBundle.setOnClickListener {
            intentBundleBMI()
        }

        //serializable
        btnSerializable.setOnClickListener {
            serializableBMI()
        }

        //parcelable
        btnParcelable.setOnClickListener {
            parcelableBMI()
        }
    }

    private fun implicitIntentBMI(){
        val pindah = Intent(Intent.ACTION_VIEW)
        pindah.data = Uri.parse("https://www.calculator.net/bmi-calculator.html")
        startActivity(pindah)
    }

    private fun explicitIntentBMI(){
        val umur = edittxtUmur.text.toString()
        val tb = edittxtTB.text.toString()
        val bb = edittxtBB.text.toString()
        val bmi = hitungBMI(bb.toDouble(), tb.toDouble())
        val kategori = kategori(bmi)
        val intent = Intent(this, Tugas2HasilBmiActivity::class.java)

        //key-value
        intent.putExtra("umur", umur)
        intent.putExtra("tb", tb)
        intent.putExtra("bb", bb)
        intent.putExtra("bmi", String.format("%.3f", bmi))
        intent.putExtra("kategori", kategori)
        intent.putExtra("klikExplicit", "true")

        startActivity(intent)
    }

    private fun intentBundleBMI(){
        val umur = edittxtUmur.text.toString()
        val tb = edittxtTB.text.toString()
        val bb = edittxtBB.text.toString()
        val bmi = hitungBMI(bb.toDouble(), tb.toDouble())
        val kategori = kategori(bmi)

        val bundle = Bundle()
        val pindah = Intent(this, Tugas2HasilBmiActivity::class.java)

        bundle.putString("umur", umur)
        bundle.putString("tb", tb)
        bundle.putString("bb", bb)
        bundle.putString("bmi", String.format("%.3f", bmi))
        bundle.putString("kategori", kategori)

        intent.putExtra("klikBundle", "true")
        pindah.putExtras(bundle)
        startActivity(pindah)
    }

    private fun serializableBMI(){
        val umur = edittxtUmur.text.toString()
        val tb = edittxtTB.text.toString()
        val bb = edittxtBB.text.toString()
        val bmi = hitungBMI(bb.toDouble(), tb.toDouble())
        val kategori = kategori(bmi)
        intent.putExtra("klikSer", "true")

        val intent = Intent(this, Tugas2HasilBmiActivity::class.java)
        val dataBmiSerializable = DataBMISerializable(umur, tb, bb, String.format("%.3f", bmi), kategori)
        intent.putExtra("databmi", dataBmiSerializable)
        startActivity(intent)
    }

    private  fun parcelableBMI(){
        val umur = edittxtUmur.text.toString()
        val tb = edittxtTB.text.toString()
        val bb = edittxtBB.text.toString()
        val bmi = hitungBMI(bb.toDouble(), tb.toDouble())
        val kategori = kategori(bmi)

        val intent = Intent(this, Tugas2HasilBmiActivity::class.java)
        val dataBMI = DataBMIParcelable(umur, tb, bb, String.format("%.3f", bmi), kategori)
        intent.putExtra("databmi", dataBMI)
        intent.putExtra("klikPar", "true")
        startActivity(intent)
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
        editTextUmur.setText("")
        editTextTB.setText("")
        editTextBB.setText("")
    }
}
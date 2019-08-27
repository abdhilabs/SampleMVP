package com.abdhilabs.learnmvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdhilabs.learnmvp.hitung.HitungActivity
import com.abdhilabs.learnmvp.model.ModelMVP
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity(), First.View {

    lateinit var presenterImp: FirstPresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenterImp = FirstPresenterImp(this)
        buttonSubmit.setOnClickListener {
            presenterImp.tambahData(inputText.text.toString())
        }

        btnPindah.setOnClickListener {
            startActivity(Intent(this, HitungActivity::class.java))
        }
    }

    override fun berhasil(hasil: ModelMVP) {
        alert {
            title = hasil.txtmsg
            noButton {
            }
            yesButton { d ->
                d.dismiss()
            }
        }.show()
    }

    override fun error() {
        toast("Tidak boleh kosong")
    }

}

package com.abdhilabs.learnmvp.hitung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abdhilabs.learnmvp.R
import com.abdhilabs.learnmvp.model.Hasil
import kotlinx.android.synthetic.main.activity_hitung.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class HitungActivity : AppCompatActivity(), HitungModel.View {

    //Deklarasi kan presenter
    lateinit var presenter: HitungPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung)

        //Panggil presenternya(klo nggak dipanggil error nnti)
        presenter = HitungPresenter(this)
        //Respon ketika di klik btn
        submitHitung.setOnClickListener {
            //Masukin data2 ke logicnya lewat View
            presenter.hitungData(input1.text.toString(), input2.text.toString())
        }
    }

    //Panggil klo berhasil, pake dialog
    override fun berhasil(hasil: Hasil) {
        alert {
            //panggil model hasil
            title = hasil.hasil
            yesButton { d ->
                d.dismiss()
            }
            noButton { n ->
                n.cancel()
            }
        }.show()
    }

    override fun error() {
        toast("Tidak boleh kosong")
    }
}

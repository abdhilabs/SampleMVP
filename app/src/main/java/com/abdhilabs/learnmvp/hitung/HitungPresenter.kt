package com.abdhilabs.learnmvp.hitung

import com.abdhilabs.learnmvp.model.Hasil

/**
 * Gampangnya di sini buat Logicnya
 * dengan Presenter
 */

class HitungPresenter(model: HitungModel.View) : HitungModel.Presenter {

    //Panggil Viewnya buat sinkronisasi/nembak data ke model
    var view: HitungModel.View? = null

    //di initialisasi viewnya
    init {
        view = model
    }

    //Buat coding logicnya
    override fun hitungData(input1: String, input2: String) {
        if (input1.isNotEmpty() && input2.isNotEmpty()) {
            val nilai1 = input1.toDouble()
            val nilai2 = input2.toDouble()
            val hasil = nilai1 * nilai2
            val model = Hasil(hasil.toString())

            //Hasilnya masukin ke model, lewat View
            view?.berhasil(model)
        } else {
            //manggil pesan error
            view?.error()
        }
    }
}
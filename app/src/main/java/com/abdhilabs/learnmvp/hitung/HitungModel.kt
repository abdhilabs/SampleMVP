package com.abdhilabs.learnmvp.hitung

import com.abdhilabs.learnmvp.model.Hasil

/**
 * Buat dulu interface nya
 * Gampangannya untuk manggil di Presenter dan View
 */

interface HitungModel {

    interface View {
        //Buat nyimpen ke model klo berhasil
        fun berhasil(hasil: Hasil)
        //pesan error klo gagal
        fun error()
    }

    interface Presenter {
        //buat logicnya
        fun hitungData(input1: String, input2: String)
    }
}
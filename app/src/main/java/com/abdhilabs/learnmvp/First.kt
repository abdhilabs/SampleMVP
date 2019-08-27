package com.abdhilabs.learnmvp

import com.abdhilabs.learnmvp.model.ModelMVP

interface First {

    interface View {
        fun berhasil(hasil: ModelMVP)
        fun error()
    }

    interface Presenter{
        fun tambahData(msg : String)
    }
}
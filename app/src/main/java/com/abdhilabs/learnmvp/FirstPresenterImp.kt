package com.abdhilabs.learnmvp

import com.abdhilabs.learnmvp.model.ModelMVP

class FirstPresenterImp(model: First.View) : First.Presenter {

    var viewModel: First.View? = null

    init {
        viewModel = model
    }

    override fun tambahData(msg: String) {
        if (msg.isNotEmpty()) {
            val model = ModelMVP(msg)

            viewModel?.berhasil(model)
        } else {
            viewModel?.error()
        }
    }
}
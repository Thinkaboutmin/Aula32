package com.trab.jetpackson2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var soma = MutableLiveData<Int>().apply {
        value = 0
    };

    fun increment(increment: Int) {
        soma.value.let {
            soma.value = it?.plus(increment)
        }
    }

    fun resetCount() {
        soma.value = 0
    }
}
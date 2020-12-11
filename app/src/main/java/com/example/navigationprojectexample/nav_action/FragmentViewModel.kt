package com.example.navigationprojectexample.nav_action

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragmentViewModel : ViewModel() {


    private val liveDataWaves = MutableLiveData<Int>()

    init {
        runDemo()
    }

    fun getLivedata(): LiveData<Int> {
        return liveDataWaves
    }

    fun runDemo() {
        var count = 0
        viewModelScope.launch {
            while (true) {
                liveDataWaves.value = count
                delay(100)
                count++
            }
        }

    }

}
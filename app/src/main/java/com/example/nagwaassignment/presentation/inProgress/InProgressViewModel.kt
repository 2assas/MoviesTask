package com.example.nagwaassignment.presentation.inProgress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InProgressViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is inProgress Fragment"
    }
    val text: LiveData<String> = _text
}
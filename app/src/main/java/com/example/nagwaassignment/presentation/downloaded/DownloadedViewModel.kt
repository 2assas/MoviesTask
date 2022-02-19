package com.example.nagwaassignment.presentation.downloaded

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DownloadedViewModel @Inject constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is downloaded Fragment"
    }
    val text: LiveData<String> = _text
}
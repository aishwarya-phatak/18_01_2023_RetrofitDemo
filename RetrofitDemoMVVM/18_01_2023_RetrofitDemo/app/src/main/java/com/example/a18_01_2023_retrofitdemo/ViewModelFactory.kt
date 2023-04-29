package com.example.a18_01_2023_retrofitdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(val myRepository: MyRepository)  : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(myRepository) as T
        }
        throw UnknownError()
    }
}
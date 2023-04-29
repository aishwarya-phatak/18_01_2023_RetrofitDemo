package com.example.a18_01_2023_retrofitdemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(val myRepository: MyRepository) : ViewModel(){
    private var currentPage = 0
    private var users = ArrayList<User>()
    private var hasMoreData = true
    var isProcessingLiveData = MutableLiveData<Boolean>(false)

    fun getUserByPage(){
        CoroutineScope(Dispatchers.IO).launch {
            isProcessingLiveData.postValue(true)
            if(hasMoreData){
                isProcessingLiveData.postValue(false)
                return@launch
            }

            var usersResponseModel = myRepository.getUsers(++currentPage)
            withContext(Dispatchers.Main){
                isProcessingLiveData.postValue(false)
                if(currentPage == usersResponseModel.totalPages){
                    hasMoreData = false
                }

                Log.e("tag",usersResponseModel.toString())
                Log.e("tag","----------------------")
                users.addAll(usersResponseModel.users)
            }

        }
    }



}
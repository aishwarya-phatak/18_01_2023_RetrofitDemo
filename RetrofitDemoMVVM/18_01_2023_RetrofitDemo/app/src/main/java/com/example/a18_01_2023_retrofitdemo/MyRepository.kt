package com.example.a18_01_2023_retrofitdemo

class MyRepository(private val apiService: ApiService) {
    suspend fun getUsers(pageNumber : Int) : UsersResponseModel{
        return apiService.getUsers(pageNumber)
    }
}
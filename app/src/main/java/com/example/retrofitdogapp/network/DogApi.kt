package com.example.retrofitdogapp.network

import retrofit2.http.GET

interface DogApiService {
    @GET("dogs")
    suspend fun getDogList(): List<Dog>
}
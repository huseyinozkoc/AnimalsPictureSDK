package com.superapp.catanddogsdk.data


import com.superapp.catanddogsdk.model.Dog
import retrofit2.http.GET

interface DogService {
    @GET("woof.json")
    suspend fun getDog(): Dog
}
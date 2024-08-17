package com.superapp.catdogsdk.data

import com.superapp.catdogsdk.model.Cat
import retrofit2.http.GET

interface CatService {
    @GET("v1/images/search")
    suspend fun getCat(): List<Cat>
}
package com.superapp.catdogsdk.data

import com.superapp.catdogsdk.model.Duck
import retrofit2.http.GET

interface DuckService {
    @GET("api/random")
    suspend fun getDuck(): Duck
}
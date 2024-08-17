package com.superapp.catdogsdk.data

import com.superapp.catdogsdk.model.Fox
import retrofit2.http.GET

interface FoxService {
    @GET("floof/")
    suspend fun getFox(): Fox
}
package com.superapp.catanddogsdk.di


import com.superapp.catanddogsdk.data.DogService
import com.superapp.catdogsdk.data.CatService
import com.superapp.catdogsdk.data.DuckService
import com.superapp.catdogsdk.data.FoxService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named("DogRetrofit")
    fun provideDogRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://random.dog/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    @Named("DogRetrofitProvider")
    fun provideDogApi(@Named("DogRetrofit") retrofit: Retrofit): DogService {
        return retrofit.create(DogService::class.java)
    }


    @Provides
    @Singleton
    @Named("FoxRetrofit")
    fun provideFoxRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://randomfox.ca/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("FoxRetrofitProvider")
    fun provideFoxApi(@Named("FoxRetrofit") retrofit: Retrofit): FoxService {
        return retrofit.create(FoxService::class.java)
    }


    @Provides
    @Singleton
    @Named("DuckRetrofit")
    fun provideDuckRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://random-d.uk/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("DuckRetrofitProvider")
    fun provideDuckApi(@Named("DuckRetrofit") retrofit: Retrofit): DuckService {
        return retrofit.create(DuckService::class.java)
    }

    @Provides
    @Singleton
    @Named("CatRetrofit")
    fun provideCatRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("CatRetrofitProvider")
    fun provideCatApi(@Named("CatRetrofit") retrofit: Retrofit): CatService {
        return retrofit.create(CatService::class.java)
    }


}
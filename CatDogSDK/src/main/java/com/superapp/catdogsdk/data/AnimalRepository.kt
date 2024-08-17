package com.superapp.catanddogsdk.data

import com.superapp.catanddogsdk.common.Resource
import com.superapp.catdogsdk.data.CatService
import com.superapp.catdogsdk.data.DuckService
import com.superapp.catdogsdk.data.FoxService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class AnimalRepository @Inject constructor(
    @Named("DogRetrofitProvider") private val dogService: DogService,
    @Named("FoxRetrofitProvider") private val foxService: FoxService,
    @Named("DuckRetrofitProvider") private val duckService: DuckService,
    @Named("CatRetrofitProvider") private val catService: CatService
) {

    fun getDog() = flow {
        emit(Resource.Loading)
        val response = try {
            dogService.getDog()
        } catch (throwable: Throwable) {
            emit(Resource.Error(throwable))
            null
        }
        response?.let { dog ->
            if (dog.url.isNotEmpty()) {
                emit(Resource.Success(dog))
            } else {
                emit(Resource.Error(Throwable("Error occurred while getting request!")))
            }
        }
    }

    fun getFox() = flow {
        emit(Resource.Loading)
        val response = try {
            foxService.getFox()
        } catch (throwable: Throwable) {
            emit(Resource.Error(throwable))
            null
        }
        response?.let { fox ->
            if (fox.image.isNotEmpty()) {
                emit(Resource.Success(fox))
            } else {
                emit(Resource.Error(Throwable("Error occurred while getting request!")))
            }
        }
    }

    fun getDuck() = flow {
        emit(Resource.Loading)
        val response = try {
            duckService.getDuck()
        } catch (throwable: Throwable) {
            emit(Resource.Error(throwable))
            null
        }
        response?.let { duck ->
            if (duck.url.isNotEmpty()) {
                emit(Resource.Success(duck))
            } else {
                emit(Resource.Error(Throwable("Error occurred while getting request!")))
            }
        }
    }

    fun getCat() = flow {
        emit(Resource.Loading)
        val response = try {
            catService.getCat()
        } catch (throwable: Throwable) {
            emit(Resource.Error(throwable))
            null
        }
        response?.let { cat ->
            if (cat.isNotEmpty()) {
                emit(Resource.Success(cat[0]))
            } else {
                emit(Resource.Error(Throwable("Error occurred while getting request!")))
            }
        }
    }
}
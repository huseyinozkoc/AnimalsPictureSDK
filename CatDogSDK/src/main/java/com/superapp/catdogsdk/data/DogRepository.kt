package com.superapp.catanddogsdk.data

import com.superapp.catanddogsdk.common.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DogRepository @Inject constructor(private val dogService: DogService) {

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
}
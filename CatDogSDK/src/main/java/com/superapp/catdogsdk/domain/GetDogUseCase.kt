package com.superapp.catanddogsdk.domain



import com.superapp.catanddogsdk.model.Dog
import com.superapp.catanddogsdk.data.DogRepository
import com.superapp.catanddogsdk.common.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDogUseCase @Inject constructor(private val dogRepository: DogRepository) {

    fun execute(): Flow<Resource<Dog>> {
        return dogRepository.getDog()
    }
}
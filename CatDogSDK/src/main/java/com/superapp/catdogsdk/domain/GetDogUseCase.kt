package com.superapp.catanddogsdk.domain



import com.superapp.catanddogsdk.model.Dog
import com.superapp.catanddogsdk.data.AnimalRepository
import com.superapp.catanddogsdk.common.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDogUseCase @Inject constructor(private val animalRepository: AnimalRepository) {

    fun execute(): Flow<Resource<Dog>> {
        return animalRepository.getDog()
    }
}
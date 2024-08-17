package com.superapp.catdogsdk.domain

import com.superapp.catanddogsdk.common.Resource
import com.superapp.catanddogsdk.data.AnimalRepository
import com.superapp.catdogsdk.model.Duck
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDuckUseCase @Inject constructor(private val animalRepository: AnimalRepository) {

    fun execute(): Flow<Resource<Duck>> {
        return animalRepository.getDuck()
    }
}
package com.superapp.catanddogsdk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superapp.catanddogsdk.common.Resource

import com.superapp.catanddogsdk.domain.GetDogUseCase
import com.superapp.catanddogsdk.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(private val getDogUseCase: GetDogUseCase) : ViewModel() {

    private val _dog = MutableStateFlow<Resource<Dog>>(Resource.Loading)
    val dog: StateFlow<Resource<Dog>> = _dog

    init {
        fetchDog()
    }

    private fun fetchDog() = viewModelScope.launch {
        getDogUseCase.execute().collect { resource ->
            _dog.value = resource
        }
    }
}
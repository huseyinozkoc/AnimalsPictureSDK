package com.superapp.catanddogsdk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superapp.catanddogsdk.common.Resource

import com.superapp.catanddogsdk.domain.GetDogUseCase
import com.superapp.catanddogsdk.model.Dog
import com.superapp.catdogsdk.domain.GetCatUseCase
import com.superapp.catdogsdk.domain.GetDuckUseCase
import com.superapp.catdogsdk.domain.GetFoxUseCase
import com.superapp.catdogsdk.model.Cat
import com.superapp.catdogsdk.model.Duck
import com.superapp.catdogsdk.model.Fox
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalViewModel @Inject constructor(
    private val getDogUseCase: GetDogUseCase,
    private val getFoxUseCase: GetFoxUseCase,
    private val getDuckUseCase: GetDuckUseCase,
    private val getCatUseCase: GetCatUseCase
) : ViewModel() {

    private val _dog = MutableStateFlow<Resource<Dog>>(Resource.Loading)
    val dog: StateFlow<Resource<Dog>> = _dog

    private val _fox = MutableStateFlow<Resource<Fox>>(Resource.Loading)
    val fox: StateFlow<Resource<Fox>> = _fox

    private val _duck = MutableStateFlow<Resource<Duck>>(Resource.Loading)
    val duck: StateFlow<Resource<Duck>> = _duck

    private val _cat = MutableStateFlow<Resource<Cat>>(Resource.Loading)
    val cat: StateFlow<Resource<Cat>> = _cat

    init {
        fetchDog()
        fetchFox()
        fetchDuck()
        fetchCat()
    }

    private fun fetchDog() = viewModelScope.launch {
        getDogUseCase.execute().collect { resource ->
            _dog.value = resource
        }
    }

    private fun fetchFox() = viewModelScope.launch {
        getFoxUseCase.execute().collect { resource ->
            _fox.value = resource
        }
    }

    private fun fetchDuck() = viewModelScope.launch {
        getDuckUseCase.execute().collect { resource ->
            _duck.value = resource
        }
    }

    private fun fetchCat() = viewModelScope.launch {
        getCatUseCase.execute().collect { resource ->
            _cat.value = resource
        }
    }
}
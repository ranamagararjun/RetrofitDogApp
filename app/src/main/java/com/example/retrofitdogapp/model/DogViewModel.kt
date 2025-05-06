package com.example.retrofitdogapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdogapp.network.Dog
import com.example.retrofitdogapp.network.DogApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogViewModel(private val apiService: DogApiService) : ViewModel() {
    private val _dogs = MutableStateFlow<List<Dog>>(emptyList())
    val dogs: StateFlow<List<Dog>> = _dogs

    init {
        fetchDogs()
    }

    private fun fetchDogs() {
        viewModelScope.launch {
            try {
                _dogs.value = apiService.getDogList()
            } catch (e: Exception) {
                // Handle error (e.g., log or show a message)
            }
        }
    }
}

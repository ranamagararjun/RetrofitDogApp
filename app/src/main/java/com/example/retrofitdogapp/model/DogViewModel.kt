package com.example.retrofitdogapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.retrofitdogapp.network.Dog
import com.example.retrofitdogapp.network.RetrofitInstance
import android.util.Log

class DogViewModel : ViewModel() {
    private val dogApiService = RetrofitInstance.api
    private val _dogs = MutableStateFlow<List<Dog>>(emptyList())
    val dogs: StateFlow<List<Dog>> = _dogs

    init {
        fetchDogs()
    }

    private fun fetchDogs() {
        viewModelScope.launch {
            try {
                val dogList = dogApiService.getDogs()
                _dogs.value = dogList
                Log.d("DogViewModel", "Fetched dogs: $dogList")
            } catch (e: Exception) {
                Log.e("DogViewModel", "Error fetching dogs", e)
            }
        }
    }
}

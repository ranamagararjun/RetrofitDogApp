package com.example.retrofitdogapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.retrofitdogapp.viewmodel.DogViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun DogInfoScreen(dogId: String?, dogViewModel: DogViewModel) {
    val dog = dogViewModel.dogs.value.find { it.title == dogId }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Dog Info Screen")
        Text(text = "Title: ${dog?.title ?: "Unknown"}")
        Text(text = "Description: ${dog?.description ?: "No description available"}")
        Text(text = "Genres: ${dog?.genres?.joinToString(", ") ?: "No genres available"}")
    }
}

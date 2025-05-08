package com.example.retrofitdogapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.retrofitdogapp.viewmodel.DogViewModel

@Composable
fun DogScreen(dogViewModel: DogViewModel, onDogSelected: (String) -> Unit) {
    val dogs = dogViewModel.dogs.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(dogs) { dog ->
            Text(
                text = dog.title ?: "Unknown Dog",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onDogSelected(dog.title ?: "") }
            )
        }
    }
}

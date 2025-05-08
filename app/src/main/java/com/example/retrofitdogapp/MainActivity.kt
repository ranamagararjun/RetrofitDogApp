package com.example.retrofitdogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retrofitdogapp.screens.DogScreen
import com.example.retrofitdogapp.screens.DogInfoScreen
import com.example.retrofitdogapp.ui.theme.RetroFitDogAppTheme
import com.example.retrofitdogapp.viewmodel.DogViewModel

class MainActivity : ComponentActivity() {
    private val dogViewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetroFitDogAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    AppNavigation(navController = navController, dogViewModel = dogViewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController, dogViewModel: DogViewModel) {
    NavHost(navController = navController, startDestination = "dog_screen") {
        composable("dog_screen") {
            DogScreen(
                dogViewModel = dogViewModel,
                onDogSelected = { dogId ->
                    navController.navigate("dog_info_screen/$dogId")
                }
            )
        }
        composable("dog_info_screen/{dogId}") { backStackEntry ->
            val dogId = backStackEntry.arguments?.getString("dogId")
            DogInfoScreen(dogId = dogId, dogViewModel = dogViewModel)
        }
    }
}

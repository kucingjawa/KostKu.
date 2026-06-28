package com.example.kostku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kostku.navigation.Screen
import com.example.kostku.ui.screens.DetailScreen
import com.example.kostku.ui.screens.HomeScreen
import com.example.kostku.ui.theme.KostKuTheme // Sesuaikan dengan nama theme lu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KostKuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KostApp()
                }
            }
        }
    }
}

@Composable
fun KostApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                navigateToDetail = { kostId ->
                    navController.navigate(Screen.Detail.createRoute(kostId))
                }
            )
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("kostId") { type = NavType.IntType })
        ) { backStackEntry ->
            val kostId = backStackEntry.arguments?.getInt("kostId") ?: -1
            DetailScreen(
                kostId = kostId,
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}
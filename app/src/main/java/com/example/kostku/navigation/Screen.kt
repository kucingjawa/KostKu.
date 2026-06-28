package com.example.kostku.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{kostId}") {
        fun createRoute(kostId: Int) = "detail/$kostId"
    }
}
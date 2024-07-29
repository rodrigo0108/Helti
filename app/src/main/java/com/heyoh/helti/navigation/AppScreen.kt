package com.heyoh.helti.navigation

sealed class AppScreen(val route: String) {
    object SplashScreen: AppScreen("splash_root")
    object LoginScreen: AppScreen("login_root")
    object MainScreen: AppScreen("main_root")
    object HomeScreen: AppScreen("home_root")
    object SearchScreen : AppScreen("search_root")
    object FavoritesScreen : AppScreen("favorites_root")
    object ProfileScreen : AppScreen("profile_root")
}

sealed class LeafScreen(val route: String) {
    object Home : LeafScreen("home")
    object Search : LeafScreen("search")
    object Favorites : LeafScreen("favorites")
    object Profile : LeafScreen("profile")
    object HomeDetail : LeafScreen("home_detail")
    object BookReader : LeafScreen("book_reader")
}
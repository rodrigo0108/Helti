package com.heyoh.helti.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.heyoh.home.screens.HomeScreen
import com.heyoh.helti.screens.FavoritesScreen
import com.heyoh.helti.screens.HomeDetailScreen
import com.heyoh.helti.screens.LoginScreen
import com.heyoh.helti.screens.MainScreen
import com.heyoh.helti.screens.ProfileScreen
import com.heyoh.helti.screens.SearchScreen
import com.heyoh.helti.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.SplashScreen.route)
    {
        composable(AppScreen.SplashScreen.route){
            SplashScreen(goToLogin = {
                navController.popBackStack()
                navController.navigate(AppScreen.LoginScreen.route)
            })
        }
        composable(AppScreen.LoginScreen.route){
            LoginScreen(goToMain = {
                navController.popBackStack()
                navController.navigate(AppScreen.MainScreen.route)
            })
        }
        composable(AppScreen.MainScreen.route){
            MainScreen()
        }
    }

}
@Composable
fun HomeNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppScreen.HomeScreen.route)
    {
        addHomeRoute(navController)
        addSearchRoute(navController)
        addFavoritesRoute(navController)
        addProfileRoute(navController)

    }

}
private fun NavGraphBuilder.addHomeRoute(navController: NavController) {
    navigation(
        route = AppScreen.HomeScreen.route,
        startDestination = LeafScreen.Home.route
    ) {
        showHome(navController)
        showHomeDetail(navController)
    }
}
private fun NavGraphBuilder.showHome(navController: NavController) {
    composable(route = LeafScreen.Home.route) {
        HomeScreen(
            showDetail = {
                navController.navigate(LeafScreen.HomeDetail.route)
            }
        )
    }
}
private fun NavGraphBuilder.showHomeDetail(navController: NavController) {
    composable(route = LeafScreen.HomeDetail.route) {
        HomeDetailScreen(
            onBack = {
                navController.navigateUp()
            }
        )
    }
}
private fun NavGraphBuilder.addSearchRoute(navController: NavController) {
    navigation(
        route = AppScreen.SearchScreen.route,
        startDestination = LeafScreen.Search.route
    ) {
        showSearch(navController)
    }
}
private fun NavGraphBuilder.showSearch(navController: NavController) {
    composable(route = LeafScreen.Search.route) {
        SearchScreen()
    }
}

private fun NavGraphBuilder.addFavoritesRoute(navController: NavController) {
    navigation(
        route = AppScreen.FavoritesScreen.route,
        startDestination = LeafScreen.Favorites.route
    ) {
        showFavorites(navController)
    }
}
private fun NavGraphBuilder.showFavorites(navController: NavController) {
    composable(route = LeafScreen.Favorites.route) {
        FavoritesScreen()
    }
}

private fun NavGraphBuilder.addProfileRoute(navController: NavController) {
    navigation(
        route = AppScreen.ProfileScreen.route,
        startDestination = LeafScreen.Profile.route
    ) {
        showProfile(navController)
    }
}
private fun NavGraphBuilder.showProfile(navController: NavController) {
    composable(route = LeafScreen.Profile.route) {
        ProfileScreen()
    }
}
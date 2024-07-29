package com.heyoh.helti.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.heyoh.helti.R
import com.heyoh.helti.navigation.AppScreen
import com.heyoh.helti.navigation.HomeNavigation

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentSelectedScreen by navController.currentScreenAsState()
    val currentRoute by navController.currentRouteAsState()
    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController,
                currentSelectedScreen = currentSelectedScreen
            )
            /***
             * Use [BottomNavBar] Like this if you wanna show it for specific routes
            if (currentRoute == null || bottomNavRoutes.contains(currentRoute)) {
            BottomNavBar(navController = navController, currentSelectedScreen = currentSelectedScreen)
            }
             ***/
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeNavigation(navController)
        }
    }
}

@Composable
private fun BottomNavBar(
    navController: NavController,
    currentSelectedScreen: AppScreen
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentSelectedScreen == AppScreen.HomeScreen,
            onClick = { navController.navigateToRootScreen(AppScreen.HomeScreen) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.home))
            },
            icon = {
                //HomeIcon()
                Icon(Icons.Filled.Home, contentDescription = null)
            }
        )
        NavigationBarItem(
            selected = currentSelectedScreen == AppScreen.SearchScreen,
            onClick = { navController.navigateToRootScreen(AppScreen.SearchScreen) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.search))
            },
            icon = {
                //SearchIcon()
                Icon(Icons.Filled.Search, contentDescription = null)
            }
        )
        NavigationBarItem(
            selected = currentSelectedScreen == AppScreen.FavoritesScreen,
            onClick = { navController.navigateToRootScreen(AppScreen.FavoritesScreen) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.favorites))
            },
            icon = {
                //FavoriteIcon()
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        )
        NavigationBarItem(
            selected = currentSelectedScreen == AppScreen.ProfileScreen,
            onClick = { navController.navigateToRootScreen(AppScreen.ProfileScreen) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.profile))
            },
            icon = {
                //ProfileIcon()
                Icon(Icons.Filled.AccountBox, contentDescription = null)
            }
        )
    }
}

@Stable
@Composable
private fun NavController.currentScreenAsState(): State<AppScreen> {
    val selectedItem = remember { mutableStateOf<AppScreen>(AppScreen.HomeScreen) }
    DisposableEffect(key1 = this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when {
                destination.hierarchy.any { it.route == AppScreen.HomeScreen.route } -> {
                    selectedItem.value = AppScreen.HomeScreen
                }

                destination.hierarchy.any { it.route == AppScreen.SearchScreen.route } -> {
                    selectedItem.value = AppScreen.SearchScreen
                }

                destination.hierarchy.any { it.route == AppScreen.FavoritesScreen.route } -> {
                    selectedItem.value = AppScreen.FavoritesScreen
                }

                destination.hierarchy.any { it.route == AppScreen.ProfileScreen.route } -> {
                    selectedItem.value = AppScreen.ProfileScreen
                }
            }

        }
        addOnDestinationChangedListener(listener)
        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return selectedItem
}

@Stable
@Composable
private fun NavController.currentRouteAsState(): State<String?> {
    val selectedItem = remember { mutableStateOf<String?>(null) }
    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            selectedItem.value = destination.route
        }
        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return selectedItem
}

private fun NavController.navigateToRootScreen(appScreen: AppScreen) {
    navigate(appScreen.route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
package com.example.receitafacil.ui.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.receitafacil.ui.presentation.navigation.screens.Graphs
import com.example.receitafacil.ui.presentation.navigation.screens.HomeScreens

fun NavGraphBuilder.homeGraph(
    onNavigateUp: () -> Unit,
) {
    navigation<Graphs.HomeGraph>(
        startDestination = HomeScreens.HomeScreen,
    ) {

    }
}
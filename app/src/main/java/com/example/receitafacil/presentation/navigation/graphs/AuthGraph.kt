package com.example.receitafacil.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.receitafacil.presentation.navigation.screens.AuthScreens
import com.example.receitafacil.presentation.navigation.screens.Graphs

fun NavGraphBuilder.authGraph(
    onNavigateToHomeGraph: () -> Unit,
) {
    navigation<Graphs.AuthGraph>(
        startDestination = AuthScreens.LoginScreen,
    ) {

    }
}
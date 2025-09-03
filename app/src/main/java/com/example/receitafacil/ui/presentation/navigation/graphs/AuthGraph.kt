package com.example.receitafacil.ui.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.receitafacil.ui.presentation.navigation.screens.AuthScreens
import com.example.receitafacil.ui.presentation.navigation.screens.Graphs

fun NavGraphBuilder.authGraph(
    onNavigateToHomeGraph: () -> Unit,
) {
    navigation<Graphs.AuthGraph>(
        startDestination = AuthScreens.LoginScreen,
    ) {

    }
}
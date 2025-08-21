package com.example.receitafacil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import br.com.myrecipesapp.presentation.ui.theme.ReceitaFacilAppTheme
import com.example.receitafacil.presentation.navigation.RootHost
import com.example.receitafacil.presentation.navigation.screens.Graphs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            ReceitaFacilAppTheme {
                val navController = rememberNavController()

                RootHost(
                    startDestination = Graphs.AuthGraph,
                    navController = navController
                )
            }
        }
    }
}
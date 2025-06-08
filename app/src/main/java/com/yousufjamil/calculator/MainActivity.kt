package com.yousufjamil.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yousufjamil.calculator.data.DataSource
import com.yousufjamil.calculator.featurescreens.History
import com.yousufjamil.calculator.ui.theme.MYJCalculatorTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()

            MYJCalculatorTheme {
                Navigation(navController)
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    DataSource.navController = navController

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen()
        }
        composable("history") {
            History()
        }
    }
}
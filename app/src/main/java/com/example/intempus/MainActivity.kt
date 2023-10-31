package com.example.intempus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.intempus.ui.main.MainScreen
import com.example.intempus.ui.theme.IntempusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntempusTheme {
                MainScreen()
            }
        }
    }
}
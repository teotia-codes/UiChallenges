package com.example.uichallenges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.uichallenges.screens.HomeScreen
import com.example.uichallenges.ui.theme.UiChallengesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UiChallengesTheme {
HomeScreen()
            }
        }
    }
}

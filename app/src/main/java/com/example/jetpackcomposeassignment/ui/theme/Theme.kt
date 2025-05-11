package com.example.jetpackcomposeassignment.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposeassignment.ui.theme.EduBluePrimary
import com.example.jetpackcomposeassignment.ui.theme.EduBlueSecondary
import com.example.jetpackcomposeassignment.ui.theme.EduBlueLight
import com.example.jetpackcomposeassignment.ui.theme.EduBlueDark
import com.example.jetpackcomposeassignment.ui.theme.EduSurface
import com.example.jetpackcomposeassignment.ui.theme.EduOnSurface

private val DarkColorScheme = darkColorScheme(
    primary = EduBluePrimary,
    secondary = EduBlueSecondary,
    tertiary = EduBlueLight,
    background = EduBlueDark,
    surface = EduBlueDark,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = EduSurface
)

private val LightColorScheme = lightColorScheme(
    primary = EduBluePrimary,
    secondary = EduBlueSecondary,
    tertiary = EduBlueLight,
    background = EduSurface,
    surface = EduSurface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = EduOnSurface,
    onSurface = EduOnSurface

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun JetpackcomposeassignmentTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
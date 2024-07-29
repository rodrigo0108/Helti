package com.heyoh.helti.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = monserratFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = monserratFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp
    ),
    titleLarge  = TextStyle(
        fontFamily = monserratFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp
    ),
    titleMedium  = TextStyle(
        fontFamily = monserratFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp
    ),
    labelMedium = TextStyle(
        fontFamily = monserratFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = monserratFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp
    )

)
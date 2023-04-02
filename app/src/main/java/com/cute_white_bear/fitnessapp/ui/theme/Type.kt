package com.cute_white_bear.fitnessapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cute_white_bear.fitnessapp.R

val raleway = FontFamily(
    Font(R.font.raleway_medium, FontWeight.Medium),
    Font(R.font.raleway_semibold, FontWeight.SemiBold),
    Font(R.font.raleway_bold, FontWeight.Bold),
    Font(R.font.raleway_black, FontWeight.Black),
    Font(R.font.raleway_extrabold, FontWeight.ExtraBold),
    Font(R.font.raleway_regular, FontWeight.Normal),
)

val lora = FontFamily(
    Font(R.font.lora_regular, FontWeight.Normal),
    Font(R.font.lora_medium, FontWeight.Medium),
    Font(R.font.lora_semibold, FontWeight.SemiBold),
    Font(R.font.lora_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontSize = 28.sp,
        fontFamily = raleway,
        fontWeight = FontWeight.Normal,
    ),
    h2 = TextStyle(
        fontSize = 20.sp,
        fontFamily = raleway,
        fontWeight = FontWeight.Normal,
    ),
    h3 = TextStyle(
        fontSize = 18.sp,
        fontFamily = raleway,
        fontWeight = FontWeight.Bold,
    ),
    h4 = TextStyle(
        fontSize = 18.sp,
        fontFamily = lora,
        fontWeight = FontWeight.Bold,
    ),
    h5 = TextStyle(
        fontSize = 16.sp,
        fontFamily = lora,
        fontWeight = FontWeight.Normal,
    ),
    body1 = TextStyle(
        fontSize = 16.sp,
        fontFamily = raleway,
        fontWeight = FontWeight.Normal,
    ),
)
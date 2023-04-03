package com.cute_white_bear.fitnessapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Exercise(
    val id: Int,
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    @StringRes val description: List<Int>,
    @StringRes val benefits: List<Int>,
)

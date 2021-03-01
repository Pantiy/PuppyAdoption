package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes

data class PuppyData(
    @DrawableRes val photo: Int,
    val name: String,
    val birthday: String,
    val isMale: Boolean,
    val breed: String,
    val location: String
)
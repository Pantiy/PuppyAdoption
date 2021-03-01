package com.example.androiddevchallenge.ui.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.PuppyData

class PuppyModel : ViewModel() {

    private val puppy = PuppyData(
        R.drawable.puppy_kiki, "Kiki", "2020.01.01", true,
        "Welsh Corgi Pembroke", "Guangzhou, China"
    )


    val puppies = mutableStateOf(
        listOf(
            PuppyData(
                R.drawable.puppy_kiki, "Kiki", "2020.01.01", true,
                "Welsh Corgi Pembroke", "Guangzhou, China"
            ),
            PuppyData(
                R.drawable.puppy_wiwi, "Wiwi", "2020.01.02", false,
                "Canis Lupus Familiaris", "Shanghai, China"
            ),
            PuppyData(
                R.drawable.puppy_pipi, "Pipi", "2020.01.03", true,
                "Australian Shepherd", "Hangzhou, China"
            ),
            PuppyData(
                R.drawable.puppy_lili, "Lili", "2020.01.04", false,
                "Poodle", "Shenzhen, China"
            ),
            PuppyData(
                R.drawable.puppy_titi, "Titi", "2020.01.05", true,
                "Siberian Husky", "Suzhou, China"
            ),
            PuppyData(
                R.drawable.puppy_cici, "Cici", "2020.01.06", false,
                "Samoyed", "Nanjing, China"
            ),
        )
    )

    var tapedPuppy: PuppyData? by mutableStateOf(null)

    fun displayPuppy(puppyData: PuppyData) {
        tapedPuppy = puppyData
    }

    fun hidePuppy() {
        tapedPuppy = null
    }
}
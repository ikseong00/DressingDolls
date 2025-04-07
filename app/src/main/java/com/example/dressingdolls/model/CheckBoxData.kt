package com.example.dressingdolls.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateListOf
import com.example.dressingdolls.R

data class CheckBoxData(
    var isChecked: Boolean,
    val value: String,
    @DrawableRes val imageRes: Int
) {
    companion object {
        val checkBoxes = mutableStateListOf(
            CheckBoxData(
                value = "arms",
                isChecked = false,
                imageRes = R.drawable.arms
            ),
            CheckBoxData(
                value = "body",
                isChecked = false,
                imageRes = R.drawable.body
            ),
            CheckBoxData(
                value = "ears",
                isChecked = false,
                imageRes = R.drawable.ears
            ),
            CheckBoxData(
                value = "eyebrows",
                isChecked = false,
                imageRes = R.drawable.eyebrows
            ),
            CheckBoxData(
                value = "eyes",
                isChecked = false,
                imageRes = R.drawable.eyes
            ),
            CheckBoxData(
                value = "glasses",
                isChecked = false,
                imageRes = R.drawable.glasses
            ),
            CheckBoxData(
                value = "hat",
                isChecked = false,
                imageRes = R.drawable.hat
            ),
            CheckBoxData(
                value = "mouth",
                isChecked = false,
                imageRes = R.drawable.mouth
            ),
            CheckBoxData(
                value = "mouth",
                isChecked = false,
                imageRes = R.drawable.mouth
            ),
            CheckBoxData(
                value = "mustache",
                isChecked = false,
                imageRes = R.drawable.mustache
            ),
            CheckBoxData(
                value = "nose",
                isChecked = false,
                imageRes = R.drawable.nose
            ),
            CheckBoxData(
                value = "shoes",
                isChecked = false,
                imageRes = R.drawable.shoes
            )
        )



    }
}

package com.example.dressingdolls.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dressingdolls.model.CheckBoxData
import com.example.dressingdolls.model.CheckBoxData.Companion.checkBoxes

@Composable
fun DollImages(
    modifier: Modifier = Modifier,
    checkBoxData: List<CheckBoxData>
) {
    Box(
        modifier = modifier
            .size(200.dp)
    ) {
        checkBoxData.forEach {
            if (it.isChecked) {
                Image(
                    painter = painterResource(id = it.imageRes),
                    contentDescription = it.value
                )
            }
        }
    }
}

@Preview
@Composable
private fun DollImagesPreview() {
    DollImages(
        checkBoxData = checkBoxes.toList()
    )
}
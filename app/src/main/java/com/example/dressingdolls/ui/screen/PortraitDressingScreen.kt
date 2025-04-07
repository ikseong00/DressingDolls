package com.example.dressingdolls.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dressingdolls.model.CheckBoxData
import com.example.dressingdolls.model.CheckBoxData.Companion.checkBoxes
import com.example.dressingdolls.ui.component.CheckBoxContainer
import com.example.dressingdolls.ui.component.DollImages

@Composable
fun PortraitDressingScreen(
    padding: PaddingValues = PaddingValues(0.dp),
    checkBoxData: List<CheckBoxData>,
    onCheckedChange: (index: Int, isChecked: Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DollImages(
            modifier = Modifier
                .padding(top = 100.dp),
            checkBoxData = checkBoxData
        )
        CheckBoxContainer(
            checkBoxData = checkBoxData,
            onCheckedChange = onCheckedChange
        )
    }
}


@Preview
@Composable
private fun DressingScreenPreview() {
    val checkBoxesState = rememberSaveable(
        saver = listSaver(
            save = { list -> list.map { Triple(it.isChecked, it.value, it.imageRes) } },
            restore = { saved ->
                mutableStateListOf<CheckBoxData>().apply {
                    addAll(saved.map { CheckBoxData(it.first, it.second, it.third) })
                }
            }
        ),
        init = { checkBoxes }
    )

    PortraitDressingScreen(
        checkBoxData = checkBoxesState.toList(),
        onCheckedChange = { index, isChecked ->
            checkBoxesState[index] = checkBoxesState[index].copy(isChecked = isChecked)
        }
    )
}
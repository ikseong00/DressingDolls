package com.example.dressingdolls.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dressingdolls.model.CheckBoxData
import com.example.dressingdolls.model.CheckBoxData.Companion.checkBoxes

@Composable
fun CheckBoxContainer(
    modifier: Modifier = Modifier,
    checkBoxData: List<CheckBoxData>,
    onCheckedChange: (Int, Boolean) -> Unit,
) {
    val state = rememberLazyGridState()

    LazyVerticalGrid(
        modifier = modifier,
        state = state,
        columns = GridCells.Fixed(2),
    ) {
        items(checkBoxData.size) { index ->
            Row(
                modifier = Modifier.clickable {
                    onCheckedChange(index, !checkBoxData[index].isChecked)
                },
            ) {
                Checkbox(
                    checked = checkBoxData[index].isChecked,
                    onCheckedChange = { checked ->
                        onCheckedChange(index, checked)
                    }
                )
                Text(
                    text = checkBoxData[index].value,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }


        }
    }

}

@Preview(showBackground = true)
@Composable
private fun CheckBoxContainerPreview() {
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
    CheckBoxContainer(
        checkBoxData = checkBoxesState,
        onCheckedChange = { index, checked ->
            checkBoxesState[index] = checkBoxesState[index].copy(isChecked = checked)
        }
    )
}


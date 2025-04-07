package com.example.dressingdolls

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.example.dressingdolls.ui.component.CheckBoxContainer
import com.example.dressingdolls.ui.theme.DressingDollsTheme
import com.example.dressingdolls.model.CheckBoxData
import com.example.dressingdolls.model.CheckBoxData.Companion.checkBoxes
import com.example.dressingdolls.ui.screen.LandScapeDressingScreen
import com.example.dressingdolls.ui.screen.PortraitDressingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DressingDollsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val checkBoxesState = rememberSaveable(
                        saver = listSaver(
                            save = { list ->
                                list.map {
                                    Triple(
                                        it.isChecked,
                                        it.value,
                                        it.imageRes
                                    )
                                }
                            },
                            restore = { saved ->
                                mutableStateListOf<CheckBoxData>().apply {
                                    addAll(saved.map {
                                        CheckBoxData(
                                            it.first,
                                            it.second,
                                            it.third
                                        )
                                    })
                                }
                            }
                        ),
                        init = { checkBoxes }
                    )

                    val orientation = LocalConfiguration.current.orientation
                    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                        PortraitDressingScreen(
                            padding = innerPadding,
                            checkBoxData = checkBoxesState.toList(),
                            onCheckedChange = { index, isChecked ->
                                checkBoxesState[index] =
                                    checkBoxesState[index].copy(isChecked = isChecked)
                            }
                        )
                    } else {
                        LandScapeDressingScreen(
                            padding = innerPadding,
                            checkBoxData = checkBoxesState.toList(),
                            onCheckedChange = { index, isChecked ->
                                checkBoxesState[index] =
                                    checkBoxesState[index].copy(isChecked = isChecked)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DressingDollsTheme {
        Greeting("Android")
    }
}
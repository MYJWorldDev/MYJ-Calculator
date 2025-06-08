package com.yousufjamil.calculator

import android.Manifest.permission_group.PHONE
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousufjamil.calculator.accessories.CalcButton
import com.yousufjamil.calculator.accessories.CalcButtonText
import com.yousufjamil.calculator.accessories.CustomMath
import com.yousufjamil.calculator.data.DataSource
import com.yousufjamil.calculator.sessionhistory.CalcHistory
import kotlinx.coroutines.launch

@Preview(showBackground = true, name = "Phone", device = PHONE)
@Composable
fun MainScreen() {
    var input by remember { mutableStateOf("0") }
    val font = FontFamily(
        Font(
            resId = R.font.stix_two_math_reg
        )
    )
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val customMath = CustomMath()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF202a31))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = input,
                modifier = Modifier
                    .padding(36.dp),
                maxLines = 1,
                softWrap = false,
                fontSize = 90.sp,
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontFamily = font
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(Color(0xFF151c21))
                .padding(20.dp),
            userScrollEnabled = false,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            item (
                span = {
                    GridItemSpan(4)
                }
            ) {
                CalcButton(
                    color = Color(0xFF0b0e10),
                    onClick = {
                        DataSource.navController.navigate("history")
                    },
                    content = {
                        CalcButtonText("\uD83D\uDD58")
                    },
                    keepAspectRatio = false
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF566f83),
                    onClick = {
                        input = "0"
                    },
                    content = {
                        CalcButtonText("\uD83D\uDDD1")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF566f83),
                    onClick = {
                        try {
                            val partHistory1 = input
                            input = customMath.sqrt(input).toString()
                            CalcHistory.AddToHistory("$partHistory1 = $input")
                        } catch (e: Exception) {
                            Toast.makeText(DataSource.navController.context, e.message, Toast.LENGTH_SHORT).show()
                        }
                    },
                    content = {
                        CalcButtonText("√")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF566f83),
                    onClick = {
                        input = input.dropLast(1)
                        if (input.isEmpty()) {
                            input = "0"
                        }
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("⌫")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF607D94),
                    onClick = {
                        if (input == "0") {
                            input = ""
                        }
                        input += "+"
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("+")
                    }
                )
            }

            items(3) {
                CalcButton(
                    color = Color(0xFF364652),
                    onClick = {
                        if (input == "0") {
                            input = ""
                        }
                        input += "${it + 1}"
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("${it + 1}")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF607D94),
                    onClick = {
                        if (input == "0") {
                            input = ""
                        }
                        input += "-"
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("-")
                    }
                )
            }

            items(3) {
                CalcButton(
                    color = Color(0xFF364652),
                    onClick = {
                        if (input == "0") {
                            input = ""
                        }
                        input += "${it + 4}"
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("${it + 4}")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF607D94),
                    onClick = {
                        input += "×"
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("×")
                    }
                )
            }


            items(3) {
                CalcButton(
                    color = Color(0xFF364652),
                    onClick = {
                        if (input == "0") {
                            input = ""
                        }
                        input += "${it + 7}"
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("${it + 7}")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF607D94),
                    onClick = {
                        input += "÷"
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("÷")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF364652),
                    onClick = {
                        if (input == "0") {
                            input = ""
                        }
                        input += "0"
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("0")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF364652),
                    onClick = {
                        if (input.last() == '+' || input.last() == '-' || input.last() == '×' || input.last() == '÷') {
                            input += "0"
                        }
                        input += "."
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText(".")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF364652),
                    onClick = {
                        input += "%"
                        coroutineScope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
                    },
                    content = {
                        CalcButtonText("%")
                    }
                )
            }

            item {
                CalcButton(
                    color = Color(0xFF607D94),
                    onClick = {
                        try {
                            val partHistory1 = input
                            input = customMath.evaluate(input).toString()
                            CalcHistory.AddToHistory("$partHistory1 = $input")
                        } catch (e: Exception) {
                            Toast.makeText(DataSource.navController.context, e.message, Toast.LENGTH_SHORT).show()
                        }
                    },
                    content = {
                        CalcButtonText("=")
                    }
                )
            }
        }
    }
}
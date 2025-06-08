package com.yousufjamil.calculator.accessories

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousufjamil.calculator.R

@Composable
fun CalcButtonText(
    text: String
) {
    val font = FontFamily(
        Font(
            resId = R.font.stix_two_math_reg
        )
    )

    Text(
        text = text,
        fontSize = 27.sp,
        maxLines = 1,
        softWrap = false,
        fontFamily = font
    )
}

@Preview(showBackground = true)
@Composable
fun CalcButtonTextPreview() {
    CalcButtonText("3")
}
package com.yousufjamil.calculator.accessories

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalcButton(
    content: @Composable () -> Unit,
    color: Color,
    onClick: () -> Unit,
    keepAspectRatio: Boolean = true
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(if (keepAspectRatio) 1f else 4f)
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun CalcButtonPreview() {
    CalcButton(
        content = {
            CalcButtonText(
                text = "333333"
            )
        },
        color = Color(0xFF607D94),
        onClick = {}
    )
}
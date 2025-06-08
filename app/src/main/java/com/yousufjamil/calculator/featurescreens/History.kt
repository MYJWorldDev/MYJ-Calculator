package com.yousufjamil.calculator.featurescreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yousufjamil.calculator.sessionhistory.CalcHistory
import androidx.compose.ui.unit.sp
import com.yousufjamil.calculator.data.DataSource

@Preview
@Composable
fun History() {
    val history = CalcHistory.history

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF202a31))
            .padding(40.dp)
    ) {
        item {
            Image(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.padding(bottom = 16.dp).clickable { DataSource.navController.popBackStack()},
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "History",
                maxLines = 1,
                softWrap = false,
                fontSize = 45.sp,
                fontWeight = FontWeight.Black,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(history.size) {
            Text(text = history[it], fontSize = 20.sp, color = Color.White)
        }
    }
}
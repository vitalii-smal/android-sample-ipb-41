package com.ipb41.android.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CounterView(viewModel: CounterViewModel, modifier: Modifier = Modifier) {
    val count by viewModel.count

    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(64.dp).fillMaxSize()) {
        Text(count.toString())
        Row {
            Button(onClick = {
                viewModel.decrement()
            }) {
                Text("-")
            }
            Button(onClick = {
                viewModel.increment()
            }) {
                Text("+")
            }
        }
    }
}
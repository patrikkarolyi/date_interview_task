package com.example.intempus.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intempus.R
import com.example.intempus.ui.theme.IntempusTheme

@Composable
fun MainScreen() {

    val showDatePicker = remember { mutableStateOf(false) }
    val showTimePicker = remember { mutableStateOf(false) }

    val dateText = remember { mutableStateOf("") }
    val timeText = remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (showDatePicker.value) {
            DatePickerScreen(
                onCancel = { showDatePicker.value = false },
                onConfirm = { date ->
                    dateText.value = date
                    showDatePicker.value = false
                }
            )
        } else if (showTimePicker.value) {
            TimePickerScreen(
                onCancel = { showTimePicker.value = false },
                onConfirm = { time ->
                    timeText.value = time
                    showTimePicker.value = false
                }
            )
        } else {
            Box {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)) {
                    Text(text = stringResource(R.string.selected_date, dateText.value))
                    Button(
                        modifier = Modifier,
                        onClick = { showDatePicker.value = true }
                    ) {
                        Text(text = stringResource(R.string.set_date))
                    }
                    Spacer(modifier = Modifier.height(60.dp))
                    Text(text = stringResource(R.string.selected_time, timeText.value))
                    Button(
                        modifier = Modifier,
                        onClick = { showTimePicker.value = true }
                    ) {
                        Text(text = stringResource(R.string.set_time))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntempusTheme {
        MainScreen()
    }
}
package com.example.intempus.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.intempus.R
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerScreen(
    dateTime: LocalDateTime = LocalDateTime.now(),
    onConfirm: (String) -> Unit,
    onCancel: () -> Unit
) {
    val timePickerState = rememberTimePickerState(
        initialHour = dateTime.hour,
        initialMinute = dateTime.minute,
        is24Hour = false,
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TimePicker(state = timePickerState)
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Button(
                modifier = Modifier,
                onClick = onCancel
            ) {
                Text(text = stringResource(R.string.cancel))
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(
                modifier = Modifier,
                onClick = { onConfirm("${timePickerState.hour}-${timePickerState.minute}") }
            ) {
                Text(text = stringResource(R.string.confirm))
            }
        }
    }
}

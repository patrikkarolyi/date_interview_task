package com.example.intempus.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.intempus.R
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerScreen(
    dateTime: LocalDateTime = LocalDateTime.now(),
    onConfirm: (String) -> Unit,
    onCancel: () -> Unit
) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli()
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        DatePicker(state = datePickerState)
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
                onClick = {
                    val selectedDate = datePickerState.selectedDateMillis?.let {
                        Instant.ofEpochMilli(it).atOffset(ZoneOffset.UTC)
                    }
                    onConfirm(selectedDate?.format(DateTimeFormatter.ISO_LOCAL_DATE) ?: "0-0-0") }
            ) {
                Text(text = stringResource(R.string.confirm))
            }
        }
    }
}
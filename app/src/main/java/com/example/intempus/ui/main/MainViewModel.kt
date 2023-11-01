package com.example.intempus.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intempus.R
import com.example.intempus.data.DateRepository
import com.example.intempus.data.UiText
import com.example.intempus.data.UiText.DynamicString
import com.example.intempus.data.UiText.StringResource
import com.example.intempus.data.dateFormatter
import com.example.intempus.data.presentation.PresentationDateModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dateRepository: DateRepository
) : ViewModel() {


    //"the most recent datetime from the database table and display it in the datetime picker"
    val mostRecentDate: StateFlow<PresentationDateModel> = dateRepository.observeMostRecentDate()
        .onStart { dateRepository.downloadAllDates() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PresentationDateModel("init", "init"),
        )

    val message = MutableSharedFlow<UiText>()

    //"dates after the current datetime of the device should be rejected"
    fun submit(dateTimeString: String) {
        viewModelScope.launch {
            try {
                if (LocalDateTime
                        .parse(dateTimeString, dateFormatter)
                        .isAfter(LocalDateTime.now())
                ) {
                    message.emit(StringResource(R.string.future_datetime_error))
                } else {
                    dateRepository.insertDate(dateTimeString)
                    message.emit(StringResource(R.string.submited))
                }
            } catch (e: Exception) {
                message.emit(DynamicString(e.message ?: ""))
            }
        }
    }
}
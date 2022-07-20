package com.shobu95.crebitscompose.ui.screens.transactions.add_edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shobu95.crebitscompose.domain.model.InvalidTransactionException
import com.shobu95.crebitscompose.domain.model.Transaction
import com.shobu95.crebitscompose.domain.use_cases.transaction.TransactionUseCases
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.AddEditTransactionEvent
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTransactionViewModel @Inject constructor(
    private val useCase: TransactionUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _type = mutableStateOf("")
    val type: State<String> = _type

    private val _amountText = mutableStateOf(TextFieldState())
    val amountText: State<TextFieldState> = _amountText

    private val _timeText = mutableStateOf(TextFieldState())
    val timeText: State<TextFieldState> = _timeText

    private val _dateText = mutableStateOf(TextFieldState())
    val dateText: State<TextFieldState> = _dateText

    private val _descText = mutableStateOf(TextFieldState())
    val descText: State<TextFieldState> = _descText

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    var transactionId: Int? = null


    init {
        savedStateHandle.get<Int>("id")?.let { id ->
            if (id != -1) {
                viewModelScope.launch {
                    useCase.getTransactionById(id)?.also { transaction ->

                        transactionId = id
                        _type.value = transaction.type.toString()

                        _amountText.value = amountText.value.copy(
                            text = transaction.amount.toString()
                        )
                        _timeText.value = timeText.value.copy(
                            text = transaction.time.toString()
                        )
                        _dateText.value = dateText.value.copy(
                            text = transaction.date.toString()
                        )
                        _descText.value = descText.value.copy(
                            text = transaction.description.toString()
                        )
                    }
                }
            }
        }

    }


    fun onEvent(event: AddEditTransactionEvent) {
        when (event) {

            is AddEditTransactionEvent.ChangeType -> {
                _type.value = event.value
            }

            is AddEditTransactionEvent.EnteredAmount -> {
                _amountText.value = amountText.value.copy(
                    text = event.value
                )
            }

            is AddEditTransactionEvent.EnteredDate -> {
                _dateText.value = dateText.value.copy(
                    text = event.value
                )
            }

            is AddEditTransactionEvent.EnteredDescription -> {
                _descText.value = descText.value.copy(
                    text = event.value
                )
            }

            is AddEditTransactionEvent.EnteredTime -> {
                _timeText.value = timeText.value.copy(
                    text = event.value
                )
            }

            is AddEditTransactionEvent.SaveTransaction -> {
                viewModelScope.launch {
                    try {
                        useCase.addTransaction(
                            Transaction(
                                id = transactionId,
                                type = type.value,
                                amount = amountText.value.text,
                                time = timeText.value.text,
                                date = dateText.value.text,
                                description = descText.value.text
                            )
                        )
                        _eventFlow.emit(
                            UiEvent.SaveTransactionSuccess
                        )
                        _eventFlow.emit(
                            UiEvent.ShowToast(
                                message = "Transaction added successfully!"
                            )
                        )
                    } catch (e: InvalidTransactionException) {
                        _eventFlow.emit(
                            UiEvent.ShowToast(
                                message = e.message ?: "Transaction couldn't be added"
                            )
                        )
                    }
                }
            }
        }
    }


    sealed class UiEvent {
        data class ShowToast(val message: String) : UiEvent()
        object SaveTransactionSuccess : UiEvent()
    }

}
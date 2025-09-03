package com.example.receitafacil.ui.presentation.features.register.presentation

import androidx.lifecycle.ViewModel
import com.example.receitafacil.core.sideeffects.SideEffect
import com.example.receitafacil.core.util.Constants
import com.example.receitafacil.ui.presentation.features.register.domain.model.RegisterInputValidationType
import com.example.receitafacil.ui.presentation.features.register.domain.usecase.RegisterUserUseCase
import com.example.receitafacil.ui.presentation.features.register.domain.usecase.ValidateRegisterInputUseCase
import com.example.receitafacil.ui.presentation.features.register.presentation.state.RegisterUserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterUserViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
    private val validateRegisterInputUseCase: ValidateRegisterInputUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUserState())
    var uiState = _uiState.asStateFlow()

    private val _sideEffectChannel = Channel<SideEffect>(capacity = Channel.BUFFERED)
    var sideEffectChannel = _sideEffectChannel.receiveAsFlow()

    fun onNameInputChange(newValue: String) {
        _uiState.update{ it.copy(nameInput = newValue) }
        checkInputValidation()
    }

    fun onEmailInputChange(newValue: String) {
        _uiState.update{ it.copy(emailInput = newValue) }
        checkInputValidation()
    }

    fun onPhoneNumberInputChange(newValue: String) {
        _uiState.update{ it.copy(phoneNumberInput = newValue) }
        checkInputValidation()
    }

    fun onPasswordInputChange(newValue: String) {
        _uiState.update{ it.copy(passwordInput = newValue) }
        checkInputValidation()
    }

    fun onPasswordRepeatedInputChange(newValue: String) {
        _uiState.update{ it.copy(passwordRepeatedInput = newValue) }
        checkInputValidation()
    }

    fun onToggleVisibilityPassword() {
        _uiState.update{ it.copy(isPasswordShow = it.isPasswordShow) }
    }

    fun onToggleVisibilityPasswordRepeated() {
        _uiState.update{ it.copy(isPasswordRepeatedShow = it.isPasswordRepeatedShow) }
    }

    private fun checkInputValidation() {
        val validationResult = validateRegisterInputUseCase(
            name = _uiState.value.nameInput,
            email = _uiState.value.emailInput,
            phone = _uiState.value.phoneNumberInput,
            password = _uiState.value.passwordInput,
            passwordRepeated = _uiState.value.passwordRepeatedInput
        )
        processInputValidation(validationResult)
    }

    private fun processInputValidation(type: RegisterInputValidationType) {
        _uiState.update {
            when(type) {
                RegisterInputValidationType.EmptyField -> {
                    it.copy(
                        errorMessageInput = Constants.ValidationAuthMessages.EMPTY_FIELD,
                        isInputValid = false
                    )
                }

                RegisterInputValidationType.NoEmail -> {
                    it.copy(
                        errorMessageInput = Constants.ValidationAuthMessages.INVALID_EMAIL,
                        isInputValid = false
                    )
                }

                RegisterInputValidationType.PasswordTooShort -> {
                    it.copy(
                        errorMessageInput = Constants.ValidationAuthMessages.PASSWORD_TOO_SHORT,
                        isInputValid = false
                    )
                }

                RegisterInputValidationType.PasswordUpperCaseMissing -> {
                    it.copy(
                        errorMessageInput = Constants.ValidationAuthMessages.PASSWORD_UPPERCASE_MISSING,
                        isInputValid = false
                    )
                }

                RegisterInputValidationType.PasswordsDoNotMatch -> {
                    it.copy(
                        errorMessageInput = Constants.ValidationAuthMessages.PASSWORDS_DO_NOT_MATCH,
                        isInputValid = false
                    )
                }

                RegisterInputValidationType.PasswordSpecialCharMissing -> {
                    it.copy(
                        errorMessageInput = Constants.ValidationAuthMessages.PASSWORD_SPECIAL_CHAR_MISSING,
                        isInputValid = false
                    )
                }

                RegisterInputValidationType.PasswordNumberMissing -> {
                    it.copy(
                        errorMessageInput = Constants.ValidationAuthMessages.PASSWORD_NUMBER_MISSING,
                        isInputValid = false
                    )
                }

                RegisterInputValidationType.PhoneNumberInvalid -> {
                    it.copy(
                        errorMessageInput = Constants.ValidationAuthMessages.PHONE_NUMBER_INVALID,
                        isInputValid = false
                    )
                }

                RegisterInputValidationType.Valid -> {
                    it.copy(
                        errorMessageInput = null,
                        isInputValid = true
                    )
                }
            }
        }
    }
}
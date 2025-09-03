package com.example.receitafacil.core.sideeffects

sealed interface SideEffect {
    data class ShowToast(val message: String) : SideEffect
}
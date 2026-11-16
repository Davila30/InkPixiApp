package com.example.inkpiki.features.auth.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

//Igual q en Register con mutable, checks y lo de la API para luego
class LoginViewModel : ViewModel() {
    //Igual q register con mutableStateOf
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var errorMessage by mutableStateOf("")

    fun onLoginClick(): Boolean {
        if (email.isBlank() || password.isBlank()) {
            errorMessage = "Rellena todos los campos"
            return false
        }
        if (!email.contains("@")) {
            errorMessage = "El correo no es válido"
            return false
        }
        errorMessage = ""
        return true
    }
}
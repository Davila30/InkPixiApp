package com.example.inkpiki.features.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    // Lo que escribe el usuario. mutableStateOf pa q actualize solo.
    var username by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var acceptTerms by mutableStateOf(false)

    // Mensaje de error que se muestra en rojo
    var errorMessage by mutableStateOf("")

    // Comprueba los datos. Devuelve true si todo está bien.
    fun onRegisterClick(): Boolean {
        if (username.isBlank() || email.isBlank() || password.isBlank()) {
            errorMessage = "Rellena todos los campos"
            return false
        }
        if (!email.contains("@")) {
            errorMessage = "El correo no es válido"
            return false
        }
        if (password.length < 6) { //podemos meter mas requisitos
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        if (!acceptTerms) {
            errorMessage = "Debes aceptar los términos"
            return false
        }
        // Todo correcto: limpiamos el error
        // Luego con la API se guarda aqui
        errorMessage = ""
        return true
    }
}
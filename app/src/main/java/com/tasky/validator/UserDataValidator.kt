package com.tasky.validator

import android.util.Patterns

object UserDataValidator {

    /**
     * The full name must be between 4 and 50 characters
     */
    fun isValidName(name: String) = name.length in 4..50

    /**
     * The email must be a valid email
     */
    fun isValidEmail(email: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    /**
     * The password needs to be at least 9 characters long
     * The password must contain lowercase and uppercase letters as well as at least one digit
     */
    fun isValidPassword(password: String): Boolean {
        var char: Char
        var capitalFlag = false
        var lowerCaseFlag = false
        var numberFlag = false
        for (i in password.indices) {
            char = password[i]
            if (Character.isDigit(char)) {
                numberFlag = true
            } else if (Character.isUpperCase(char)) {
                capitalFlag = true
            } else if (Character.isLowerCase(char)) {
                lowerCaseFlag = true
            }
            if (numberFlag && capitalFlag && lowerCaseFlag && password.length > 8) return true
        }
        return false
    }
}
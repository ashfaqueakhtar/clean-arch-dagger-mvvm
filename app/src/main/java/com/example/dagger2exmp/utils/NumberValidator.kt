package com.example.dagger2exmp.utils

class NumberValidator {

    fun isPositive(number: Int): Boolean {
        return when {
            number > 0 -> true
            else -> false
        }
    }
}
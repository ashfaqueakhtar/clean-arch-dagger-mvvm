package com.example.dagger2exmp.utils

import java.lang.StringBuilder

object StringReversal {
    fun stringReverse(str: String): String {
        val s = StringBuilder()
        for (i in str.length - 1 downTo 0) {
            s.append(str[i])
        }
        return s.toString()
    }
}
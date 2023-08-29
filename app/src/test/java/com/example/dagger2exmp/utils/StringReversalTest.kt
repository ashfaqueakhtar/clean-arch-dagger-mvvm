package com.example.dagger2exmp.utils

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Before
import org.junit.Test

class StringReversalTest{
    lateinit var SUT: StringReversal

    @Before
    fun setUp() {
        SUT = StringReversal
    }

    @Test
    fun reverse_emptyString_emptyStringReturned() {
        val res = SUT.stringReverse("")
        assertThat(res,`is`(""))
    }

    @Test
    fun reverse_singleChar_sameCharReturned(){
        val res = SUT.stringReverse("a")
        assertThat(res,`is`("a"))
    }

    @Test
    fun reverse_longString_reversedLongStringReturned() {
        val res = SUT.stringReverse("Ashfaque Akhtar")
        assertThat(res,`is`("rathkA euqafhsA"))
    }
}
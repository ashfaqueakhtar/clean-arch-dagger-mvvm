package com.example.dagger2exmp.utils

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Before
import org.junit.Test

class NumberValidatorTest{
    lateinit var SUT : NumberValidator

    @Before
    fun setUp(){
        SUT = NumberValidator()
    }

    @Test
    fun test1(){
        val result : Boolean = SUT.isPositive(-1)
        assertThat(result, equalTo(false))
    }

    @Test
    fun test2(){
        val result : Boolean = SUT.isPositive(0)
        assertThat(result, equalTo(false))
    }

    @Test
    fun test3(){
        val result : Boolean = SUT.isPositive(34)
        assertThat(result, equalTo(true))
    }
}
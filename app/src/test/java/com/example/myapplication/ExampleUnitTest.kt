package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example unit test
 *
 * @constructor Create empty Example unit test
 */
class ExampleUnitTest {

    /**
     * Addition_is correct
     *
     */
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    /**
     * Example_one
     *
     * @param isValid description isValid
     */
    @Test
    fun example_One(isValid: Boolean) {
        assertEquals(isValid, true)
    }

    /**
     * Example_two
     *
     * @param param1 description param 1
     * @param param2 description param 2
     */
    @Test
    fun example_Two(param1:Int, param2:Int) {
        assertEquals(4, param1+param2)
    }

    /**
     * Example_three
     *
     * @return true/ false
     */
    @Test
    fun example_Three(): Boolean {
        assertEquals(4, 2 + 2)
        return true
    }



}
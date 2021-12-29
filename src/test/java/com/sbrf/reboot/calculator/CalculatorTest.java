package com.sbrf.reboot.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class   CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, new Calculator().getAddition(4, 5));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, new Calculator().getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20, new Calculator().getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(3, new Calculator().getDivision(9, 3));
    }

    @Test
    void getAdditionTest1() { assertEquals(100, new Calculator().getAddition(100, 0)); }

    @Test
    void getSubtractionTest1() {
        assertEquals(0, new Calculator().getSubtraction(777, 777));
    }

    @Test
    void getMultiplicationTest1() {
        assertEquals(1000, new Calculator().getMultiplication(20, 50));
    }

    @Test
    void getDivisionTest1() {
        assertEquals(7, new Calculator().getDivision(63, 9));
    }

    @Test
    void getPowTest0() {
        assertEquals(64, new Calculator().getPow(2, 6));
    }

    @Test
    void getFactorialTest0() {
        assertEquals(40320, new Calculator().getFactorial(8));
    }

    @Test
    void getGCDTest0() { assertEquals(25, new Calculator().getGCD(125, 75)); }

    @Test
    void classHasSevenMethods() {
        assertEquals(7, Calculator.class.getMethods().length - Object.class.getMethods().length);
    }
}
package com.sbrf.reboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator();
        int actual = calculator.add(1, 1);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void sub() {
        Calculator calculator = new Calculator();
        int actual = calculator.sub(100, 1);
        int expected = 99;
        assertEquals(expected, actual);
    }

    @Test
    void mul() {
        Calculator calculator = new Calculator();
        int actual = calculator.mul(11, 10);
        int expected = 110;
        assertEquals(expected, actual);
    }

    @Test
    void div() {
        Calculator calculator = new Calculator();
        int actual = calculator.div(110, 11);
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void squaring() {
        Calculator calculator = new Calculator();
        int actual = calculator.squaring(10);
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void invert() {
        Calculator calculator = new Calculator();
        int actual = calculator.invert(1);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void factorial() {
        Calculator calculator = new Calculator();
        int actual = calculator.factorial(3);
        int expected = 6;
        assertEquals(expected, actual);
    }
}
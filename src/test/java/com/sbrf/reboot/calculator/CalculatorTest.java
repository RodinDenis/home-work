package com.sbrf.reboot.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, Calculator.getAddition(4, 5));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, Calculator.getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20, Calculator.getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(3, Calculator.getDivision(9, 3));
    }

    @Test
    void classHasSevenMethods(){
        assertEquals(7,Calculator.class.getMethods().length-Object.class.getMethods().length);
    }

    @Test
    void getSquare() {assertEquals(81, Calculator.getSquare(9)); }

    @Test
    void getReverseSign() {assertEquals(-9, Calculator.getReverseSign(9)); }

    @Test
    void getReverseSign2() {assertEquals(9, Calculator.getReverseSign(-9)); }

    @Test
    void getReverseSign3() {assertEquals(0, Calculator.getReverseSign(0)); }

    @Test
    void getAbs() {assertEquals(9, Calculator.getAbs(9)); }

    @Test
    void getAbs2() {assertEquals(9, Calculator.getAbs(-9)); }

    @Test
    void getAbs3() {assertEquals(0, Calculator.getAbs(0)); }

}
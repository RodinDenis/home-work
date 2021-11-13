package com.sbrf.reboot.calculator;

import com.sbrf.reboot.Calculator;
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
    void getSquareRootPositive() {
        assertEquals(3, Calculator.getSquareRoot(9));
    }

    @Test
    void getSquareRootNegative() {
        assertEquals(-1, Calculator.getSquareRoot(-9));
    }

    @Test
    void getLogarifmPositive() {
        assertEquals(1, Calculator.getLogarifm(Math.E));
    }

    @Test
    void getLogarifmNegative() {
        assertEquals(Double.NaN, Calculator.getLogarifm(-1));
    }

    @Test
    void getFactorial() {
        assertEquals(2*3*4, Calculator.getFactorial(4));
    }
}
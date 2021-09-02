package com.sbrf.reboot.calculator;

public class Calculator {
    public static int getAddition(int i, int i1) {
        return i + i1;
    }

    public static int getSubtraction(int i, int i1) {
        return i - i1;
    }

    public static int getMultiplication(int i, int i1) {
        return i * i1;
    }

    public static int getDivision(int i, int i1) {
        return i / i1;
    }


    public static int getSquare(int i) {
        return i * i;
    }

    public static int getReverseSign(int i) {
        return -i;
    }

    public static int getAbs(int i) {
        return Math.abs(i);
    }
}

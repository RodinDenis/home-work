package com.sbrf.reboot;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int squaring(int a) {
        return a * a;
    }

    public int invert(int a) {
        return -a;
    }

    public int factorial(int a) {
        int result = 1;

        for (int i = 1; i <= a; i++) {
            result *= i;
        }

        return result;
    }

}

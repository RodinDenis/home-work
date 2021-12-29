package com.sbrf.reboot.calculator;

public class Calculator {

    /**
     * Метод для подсчета наибольшего общего делителя двух чисел
     * @param a Целочисленное число.
     * @param b Целочисленное число.
     * @return Наибольший общий делитель чисел a и b.
     */
    public int getGCD(int a, int b){
        int temp;
        if(a < 0) a = -a;
        if(b < 0) b = -b;
        while(b != 0)
        {
            if(b > a)
            {

                a = b - a;
                b = b - a;
                a = a + b;
            }

            if(b == 0) return a;

            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * @param a Целочисленное число.
     * @return Возвращает факториал числа a.
     */
    public int getFactorial(int a){
        int res = 1;
        for (int i = 2; i <= a; ++i){
            res *= i;
        }
        return res;
    }

    /**
     * Дихотомический алгоритм быстрого возведения числа в степень.
     * @param a Целочисленное число, которое возводится в степень.
     * @param b Целочисленный показатель числа a.
     * @return Возвращает результат возведения числа a в степень b.
     */
    public int getPow(int a, int b) {
        int r = 1;
        while(b > 0) {
            if((b&1) != 0) r *= a;
            a *= a;
            b >>= 1;
        }
        return r;
    }

    public int getAddition(int a, int b) {
        return a + b;
    }

    public int getSubtraction(int a, int b) {
        return a - b;
    }

    public int getMultiplication(int a, int b) {
        return a * b;
    }

    public int getDivision(int a, int b) {
        return a / b;
    }
}

package com.sbrf.reboot;

public class Calculator {
    /**
     * Вычисление сложения
     * @param x - слагаемое 1
     * @param y - слагаемое 2
     * @return результат сложения параметров
     */
    public static int getAddition(int x, int y) {
        return x + y;
    }

    /**
     * Вычисление вычитания
     * @param x - уменьшаемое
     * @param y - вычитаемое
     * @return результат вычитания вычитаемого из уменьшаемого
     */
    public static int getSubtraction (int x, int y) {
        return x - y;
    }

    /**
     * Вычисление произведения
     * @param x - множитель 1
     * @param y - множитель 2
     * @return результат произведения параметров
     */
    public static int getMultiplication (int x, int y) {
        return x * y;
    }

    /**
     * Вычисление функции деления
     * При знаменателе = 0 возврат NaN
     * @param x - числитель
     * @param y - знаменатель, не равен 0
     * @return результат деления числителя на знаменатель
     */
    public static double getDivision (double x, double y) {
        if (y==0) {
            return Double.NaN;
        }
        else
            return x / y;
    }

    /**
     * Вычисление квадратного корня
     * @param x параметр для вычисления квадратного корня, >= 0
     * @return кваддратный корень, если переданнй параметр < 0, возврат -1
     */
    public static double getSquareRoot (double x) {
        if (x < 0)
            return -1;
        else
            return Math.sqrt(x);
    }

    /**
     * Вычисление натурального логарифма переданного параметра
     * Если параметр <=0, возврат NaN
     * @param x параметр для вычисления наурального логарифма, > 0
     * @return натуральные логарифм
     */
    public static double getLogarifm (double x) {
        if (x <= 0) {
            return Double.NaN;
        }
        else
            return Math.log(x);
    }

    /**
     * Факториал: произведение целых чисел от 1 до переданного параметра включительно
     * Если передан 0, возврат 1
     * Если переданное число меньше 0, возврат 0
     * @param x параметр для вычисления факториала, >= 0
     * @return произведение целых чисел от 1 до переданного параметра включительно
     */
    public static int getFactorial (int x) {
        if (x == 0 )
            return 0;
        else {
            if (x == 1) {
                return x;
            } else
                return x * getFactorial(x - 1);
        }
    }
}

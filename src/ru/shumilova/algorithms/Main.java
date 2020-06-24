package ru.shumilova.algorithms;

public class Main {
    /**
     * Используемые правила подсчета сложности данных алгоритмов:
     * <p>
     * 1. Если алгоритму необходимо выполнить действия n раз,
     * то сложность алгоритма записывается как О(n).
     * <p>
     * 5. Постоянными множителями и константами можно пренебречь.
     */

    public static void main(String[] args) {
        System.out.println(exponentiation(2, 3));
        System.out.println(exponentiation(2, 5));
        System.out.println(exponentiation(2, 10));
        System.out.println(exponentiation(2, 7));

        System.out.println(minimalElement(new int[]{5, 10, 2, 18, -1, -3, 5, 17}));

        System.out.println(average(new int[]{2, 6, 8}));
    }

    private static int exponentiation(int number, int exponent) {
        //сложность O(n)
        int result = number;
        for (int i = 1; i < exponent; i++) {
            result *= number;
        }
        return result;
    }

    private static int minimalElement(int[] arr) {
        //сложность O(n)
        if (arr != null && arr.length > 0) {
            int result = arr[0];
            for (int number : arr) {
                if (number < result) {
                    result = number;
                }
            }
            return result;
        } else {
            throw new IllegalArgumentException("Массив должен содержать хотя бы один элемент!");
        }
    }

    private static double average(int[] arr) {
        //сложность O(n)
        if (arr != null && arr.length > 0) {
            double result = 0;
            for (int number : arr) {
                result += number;
            }
            return result / arr.length;
        } else {
            throw new IllegalArgumentException("Массив должен содержать хотя бы один элемент!");
        }
    }
}

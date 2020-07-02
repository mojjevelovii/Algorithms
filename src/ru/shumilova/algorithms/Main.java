package ru.shumilova.algorithms;

import java.util.Stack;

public class Main {
    /*
    1. Создать программу, которая переворачивает вводимые строки (читает справа налево).
    2. Создать класс для реализации дека.
    3. Реализовать класс с приоритетной очередью
    */


    public static void main(String[] args) {
        System.out.println(stringReverse("abc"));
    }

    private static String stringReverse(String string) {
        Stack<Character> chars = new Stack<>();
        for (char ch : string.toCharArray()) {
            chars.push(ch);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!chars.empty()){
            stringBuilder.append(chars.pop());
        }
        return stringBuilder.toString();
    }
}

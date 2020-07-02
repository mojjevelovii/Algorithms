package ru.shumilova.algorithms;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        MyDeque myDeque = new MyDeque(7);
        myDeque.insertLeft(4);
        myDeque.insertLeft(9);
        myDeque.insertRight(2);
        System.out.println(myDeque.removeRight());
        System.out.println(myDeque.removeRight());
        System.out.println(myDeque.removeLeft());
        System.out.println(myDeque.removeLeft());

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

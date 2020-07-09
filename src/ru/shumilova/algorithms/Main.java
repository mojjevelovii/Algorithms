package ru.shumilova.algorithms;

public class Main {

    public static void main(String[] args) {
        hanoi(5, 1, 2, 3);
    }

    static void hanoi(int count, int one, int two, int three) {
        if (count == 0) return;
        hanoi(count - 1, one, three, two);
        System.out.println(one + "-->" + two);
        hanoi(count - 1, three, two, one);
    }
}

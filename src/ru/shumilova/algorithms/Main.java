package ru.shumilova.algorithms;

public class Main {
    public static void main(String[] args) {
        int[] arr; // int arr[]
        arr = new int[5];
        int[] arr2 = {1, 2, 3, 4};

        Array a0 = new Array(1, -2, -3, -4, 5);
        Array a1 = new Array(1, -9, -3, 9, 5, 10, 1, -9, -3, 9, 5, 10);
        Array a2 = new Array(1, -9, -3, 9, 5, 10, 1, -9, -3, 9, 5, 10);
        System.out.println(a0);

        a0.deleteIndex(2);
        System.out.println(a0);

        a0.deleteValue(-4);
        System.out.println(a0);

        a0.deleteAll();
        System.out.println(a0);

        a0.insert(2,100);
        System.out.println(a0);

        a0.insert(1,13);
        System.out.println(a0);

        a0.insert(0,9);
        System.out.println(a0);

        a0.insert(4,7);
        System.out.println(a0);

        a1.betterSortBubble();
        System.out.println(a1);

        a2.sortBubble();
        System.out.println(a2);

    }
}
package ru.shumilova.algorithms;

class MyPriorityQueue {
    private int maxSize;
    private int[] prQArr;
    private int items;

    public MyPriorityQueue(int i) {
        maxSize = i;
        prQArr = new int[maxSize];
        items = 0;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public long peek() {
        return prQArr[items - 1];
    }

    public int remove() {
        return prQArr[--items];
    }

    public void insert(int item) {
        int i;
        if (items == 0)
            prQArr[items++] = item;
        else {
            for (i = items - 1; i >= 0; i--) {
                if (item > prQArr[i])
                    prQArr[i + 1] = prQArr[i];
                else
                    break;
            }
            prQArr[i + 1] = item;
            items++;
        }
    }
}
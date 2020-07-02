package ru.shumilova.algorithms;

public class MyDeque {
    private int capacity;
    private int[] deque;
    private int head;
    private int tail;

    public MyDeque(int capacity) {
        this.capacity = capacity;
//        head = 0;
//        tail = -1;
        deque = new int[capacity];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void insertLeft(int value) {
        deque[head] = value;
        if (--head < 0) {
            head = capacity - 1;
        }
    }

    public void insertRight(int value) {
        if (++tail == capacity) {
            tail = 0;
        }
        deque[tail] = value;
    }

    public int removeLeft() {
        if (++head == capacity) {
            head = 0;
        }
        return deque[head];
    }

    public int removeRight() {
        int remove = deque[tail];
        if (--tail < 0) {
            tail = capacity - 1;
        }
        return remove;
    }


}

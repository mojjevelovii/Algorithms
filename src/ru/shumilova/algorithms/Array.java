package ru.shumilova.algorithms;

import java.util.Arrays;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    public Array(int... args) {
        this();
        updateSize(args);
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
    }

    public int length() {
        return size;
    }

    private void increaseCapacity() {
        int[] temp = arr;
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public void append(int value) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        arr[size++] = value;
        isSorted = false;
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);

        return arr[--size];
    }

    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
    }

    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++)
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            swap(flag, cMin);
        }
        isSorted = true;
    }

    public void sortInsert() {
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }

    public boolean deleteValue(int val) {
        int position = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                position = i;
                break;
            }
        }
        boolean result;
        if (position != -1) {
            deleteFromPosition(position);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean deleteIndex(int index) {
        boolean result;
        if (index > -1 && index < arr.length) {
            deleteFromPosition(index);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    private void deleteFromPosition(int index) {
        int[] arr1;
        int[] arr2;
        arr1 = Arrays.copyOfRange(arr, 0, index);
        arr2 = Arrays.copyOfRange(arr, index + 1, arr.length);
        int[] newArr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, newArr, 0, arr1.length);
        System.arraycopy(arr2, 0, newArr, arr1.length, arr2.length);
        arr = newArr;
        updateSize(arr);
    }

    public void deleteAll() {
        arr = new int[0];
        updateSize(arr);
    }

    private void updateSize(int[] arr) {
        size = arr.length;
    }

    public boolean insert(int index, int value) {
        if (index > -1) {
            int[] newArr;
            if (index > arr.length) {
                 newArr = insertInOutArrayBounds(index, value);
            } else {
                newArr = insertInArrayBounds(index, value);
            }
            arr = newArr;
            updateSize(arr);
            return true;
        } else {
            return false;
        }
    }

    private int[] insertInOutArrayBounds(int index, int value) {
        int[] newArr2 = new int[index + 1];
        System.arraycopy(arr, 0, newArr2, 0, arr.length);
        newArr2[index] = value;
        return newArr2;
    }

    private int[] insertInArrayBounds(int index, int value) {
        int[] newArr = new int[arr.length + 1];
        if (index == 0) {
            System.arraycopy(arr, 0, newArr, 1, arr.length);
        } else {
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(arr, index, newArr, index+1, arr.length - index);
        }
        newArr[index] = value;
        return newArr;
    }
}

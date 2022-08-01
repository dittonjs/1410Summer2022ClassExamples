package com.usu;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        int[] data2 = {1,1,1,1,1,1,1,1,2,2,2,1000,10020,1,2,2,2};
        int[] data = {22, 8, 45, 16, 3, 0, 54, 23, 1, 4, 37};
        quickSort(data);
        for (int value: data) {
            System.out.printf("%d ", value);
        }
    }

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int start, int end) {
        if (start > end) return;
        int index = partition(data, start, end);
        quickSort(data, start, index - 1);
        quickSort(data, index + 1, end);
    }

    public static int partition(int[] data, int start, int end) {
        int middle = (start + end) / 2;
        int temp = data[start];
        data[start] = data[middle];
        data[middle] = temp;

        int pivotIndex = start;
        for (int i = start + 1; i <= end; i ++) {
            if (data[i] < data[start]) {
                pivotIndex++;
                temp = data[pivotIndex];
                data[pivotIndex] = data[i];
                data[i] = temp;
            }
        }

        temp = data[start];
        data[start] = data[pivotIndex];
        data[pivotIndex] = temp;
        return pivotIndex;
    }
}

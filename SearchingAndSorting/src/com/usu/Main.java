package com.usu;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] test1 = genArray(100000);
//        long test1Start = System.currentTimeMillis();
//        selectionSort(test1);
//        long test1End = System.currentTimeMillis();
//        int[] test2 = genArray(100000);
//        long test2Start = System.currentTimeMillis();
//        bubbleSort(test2);
//        long test2End = System.currentTimeMillis();
//        System.out.printf("Test 1 took %d milliseconds\n", test1End - test1Start);
//        System.out.printf("Test 2 took %d milliseconds\n", test2End - test2Start);
        int[] data = {1};
        System.out.println(binarySearch(data, 879));
    }

    //    int[] data = {1,2,3};
    private static void bubbleSort(int[] data) {
        boolean didSwap;
        do { // n
            didSwap = false;
            for(int i = 0; i < data.length - 1; i++) { // n
                if (data[i] > data[i+1]) {
                    didSwap = true;
                    swap(i, i+1, data);
                }
            }
        } while(didSwap);
    }
    // int[] data = {2,2,233,23,44,4334,4,5,6,34,5,543,345,4};
    private static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1;  i ++) {
            // find smallest value
            int position = findPositionOfSmallestValue(data, i);
            swap(i, position, data);
        }

    }

    private static int findPositionOfSmallestValue(int[] data, int start) {
        int position = start;
        for (int i = start; i < data.length; i ++) {
            if (data[i] < data[position]) {
                position = i;
            }
        }
        return position;
    }



    private static void swap(int position1, int position2, int[] data) {
        int temp = data[position1];
        data[position1] = data[position2];
        data[position2] = temp;
    }

    private static boolean linearSearch(int[] data, int query) {
        for(int i = 0; i < data.length; i ++) {
            if (data[i] == query) {
                return true;
            }
        }
        return false;
    }

    // [1,34,66,678,7897,435673]
    private static boolean binarySearch(int[] data, int query) {
        int start = 0;
        int end = data.length - 1;
        int middle = data.length / 2;
        while(start <= end) {
            if (data[middle] > query) { // query is to the left
                end = middle - 1;
            } else if(data[middle] < query) { // to the right
                start = middle + 1;
            } else {
                return true;
            }
            middle = (start + end) / 2;
        }
        return false;
    }

    private static void displayData(int[] data) {
        for (int value : data) {
            System.out.printf("%d, ", value);
        }
        System.out.println();
    }


    private static int[] genArray(int amount) {
        int[] data = new int[amount];
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            data[i] = random.nextInt(10000);
        }
        return data;
    }


}

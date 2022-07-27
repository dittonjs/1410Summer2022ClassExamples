package com.usu;

public class Main {

    public static void main(String[] args) {
	// write your code here
        char[][] world = {
                {' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ','*',' ',' '},
                {' ',' ',' ',' ','*',' ',' ',' '},
                {' ',' ',' ','*',' ',' ',' ',' '},
                {' ',' ','*',' ',' ',' ',' ',' '},
                {' ','*',' ',' ',' ',' ',' ',' '},
                {'*',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '},
        };

        int[] data = {1,44,345,3,2,3,5,6,66,344,3,2,34,2};
        System.out.println(linearSearch(data, 3));
        selectionSort(data);
        System.out.println(binarySearch(data, 0));
        findPath(world, 0, 0, 7, 7);

        for (int i = 0; i < world.length; i ++ ){
            for (int j = 0; j < world[i].length; j ++ ) {
                System.out.print(world[i][j]);
            }
            System.out.println();
        }

    }

    public static int computeSum(int value) {
        // base case
        if (value == 0) return 0;
        return value + computeSum(value - 1);
    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n-1) + fib(n-2);
    }

    public static boolean linearSearch(int[] data, int value) {
        return linearSearch(data, value, 0, data.length - 1);
    }

    public static boolean linearSearch(int[]data, int value, int start, int end) {
        if (start > end) return false;
        if (data[start] == value) return true;
        return linearSearch(data, value, start + 1, end);
    }

    public static void selectionSort(int[] data) {
        selectionSort(data, 0, data.length - 1);
    }

    public static void selectionSort(int[] data, int start, int end) {
        if (start == end) return;
        int smallest = start;
        for (int i = start; i <= end; i++) {
            if (data[i] < data[smallest]) {
                smallest = i;
            }
        }
        int temp = data[start];
        data[start] = data[smallest];
        data[smallest] = temp;
        selectionSort(data, start + 1, end);
    }

    public static boolean binarySearch(int[] data, int value) {
        return binarySearch(data, value, 0, data.length - 1);
    }

    public static boolean binarySearch(int[] data, int value, int start, int end) {
        if (start > end) return false;
        int middle = (start + end) / 2;
        if (data[middle] == value) return true;

        if (data[middle] > value) { // value is to the left
            return binarySearch(data, value, start, middle - 1);
        } else { // value is to the right
            return binarySearch(data, value, middle + 1, end);
        }
    }

    public static void findPath(char[][] world, int startRow, int startCol, int endRow, int endCol) {
        if (startRow < 0 || startRow > world.length - 1) return;
        if (startCol < 0 || startCol > world[startRow].length - 1) return;
        if (world[startRow][startCol] == '*') return;
        if (world[startRow][startCol] == 'v') return;

        world[startRow][startCol] = 'v';

        if (startRow == endRow && startCol == endCol) return;

        findPath(world, startRow + 1, startCol, endRow, endCol);
        findPath(world, startRow - 1, startCol, endRow, endCol);
        findPath(world, startRow, startCol + 1, endRow, endCol);
        findPath(world, startRow, startCol - 1, endRow, endCol);

    }
}

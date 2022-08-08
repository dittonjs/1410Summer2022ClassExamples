package com.usu;

import jdk.jshell.execution.JdiExecutionControl;

import java.util.ArrayList;

public class Main {
    static char[][] maze = {
            {' ', ' ', ' ', ' '},
            {'*', '*', '*', ' '},
            {' ', ' ', ' ', ' '},
            {' ', '*', '*', '*'},
            {' ', ' ', ' ', ' '},
            {' ', '*', '*', ' '},
            {' ', '*', ' ', ' '},
            {' ', '*', '*', ' '},
            {' ', '*', ' ', ' '},
    };

    public static void main(String[] args) {
	// write your code here
//        traverseMaze(maze, 0, 0, 8, 0);
//        for (char[] row : maze) {
//            for(char value : row) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }
        FixedSizeQueue queue = new FixedSizeQueue(5);
        queue.enqueue(5);
        queue.enqueue(23);
        queue.enqueue(45);
        queue.dequeue();
        queue.enqueue(54);
        queue.dequeue();
        queue.enqueue(543);
        System.out.println();
        FixedSizeStack stack = new FixedSizeStack(5);
        System.out.println();
    }

    public static void traverseMaze(char[][] maze, int startRow, int startCol, int endRow, int endCol) {
        Stack<int[]> backtrackStack = new Stack<>();
        int currentRow = startRow;
        int currentCol = startCol;
        while(!(currentRow == endRow && currentCol == endCol)) {
            ArrayList<int[]> destinations = new ArrayList<>();
            if (currentCol > 0 && maze[currentRow][currentCol - 1] == ' ') {
                destinations.add(new int[]{currentRow, currentCol - 1 });
            }
            if (currentCol < maze[currentRow].length - 1 && maze[currentRow][currentCol + 1] == ' ') {
                destinations.add(new int[]{currentRow, currentCol + 1 });
            }
            if (currentRow > 0 && maze[currentRow - 1][currentCol] == ' ') {
                destinations.add(new int[]{currentRow - 1, currentCol});
            }
            if (currentRow < maze.length - 1 && maze[currentRow + 1][currentCol] == ' ') {
                destinations.add(new int[]{currentRow + 1, currentCol,});
            }
            if (destinations.isEmpty()) {
                int[] backtrackPosition = backtrackStack.pop();
                destinations.add(backtrackPosition);
            } else if(destinations.size() > 1) {
                backtrackStack.push(new int[]{currentRow, currentCol});
            }
            maze[currentRow][currentCol] =  '.';
            currentRow = destinations.get(0)[0];
            currentCol = destinations.get(0)[1];
        }
        maze[currentRow][currentCol] = 'X';
    }
}

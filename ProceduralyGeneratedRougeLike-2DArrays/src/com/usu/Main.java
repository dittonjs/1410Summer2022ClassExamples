package com.usu;

import java.util.Arrays;
import java.util.Random;

public class Main {
    // P = player
    // * = wall
    // M = monsters
    // K = key
    // D = door
    public static void main(String[] args) {
        char[][] map = new char[40][];
        fillMap(map);
        createWalls(map);
        generateInnerWalls(map);
        map = doCellularAutomata(map);
        displayMap(map);
    }

    public static void fillMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            map[i] = new char[40];
            Arrays.fill(map[i], ' ');
        }
    }

    public static void createWalls(char[][] map) {
        Arrays.fill(map[0], '*');
        Arrays.fill(map[map.length - 1], '*');
        for (int i = 0; i < map.length; i++) {
            map[i][0] = '*';
            map[i][map[i].length - 1] =  '*';
        }
    }

    public static void generateInnerWalls(char[][] map) {
        Random random = new Random();
        for (int i = 2; i < map.length - 2; i++) {
            for (int j = 2; j < map[i].length - 2; j ++) {
                if (random.nextDouble() < .4) {
                    map[i][j] = '*';
                }
            }
        }
    }
    public static char[][] copyMap(char[][] map) {
        char[][] newMap = new char[map.length][];
        for (int i = 0; i < map.length; i++) {
            newMap[i] = new char[map[i].length];
            System.arraycopy(map[i], 0, newMap[i], 0, map[i].length);
        }
        return newMap;
    }
    public static char[][] doCellularAutomata(char[][] map) {
        char[][] mapCopy = null;
        for (int k = 0; k < 40; k ++) {
            mapCopy = copyMap(map);
            for (int i = 2; i < map.length - 2; i++) {
                for (int j = 2; j < map[i].length - 2; j ++) {
                    int count = countNumberOfNeighbors(map, i, j);
                    if (map[i][j] == '*' && count < 3) {
                        mapCopy[i][j] = ' ';
                    } else if(map[i][j] == ' ' && count > 4) {
                        mapCopy[i][j] = '*';
                    }
                }
            }
            map = mapCopy;
        }
        return mapCopy;
    }

    public static int countNumberOfNeighbors(char[][] map, int row, int col) {
        int count = 0;
        if (map[row - 1][col - 1] == '*') count ++;
        if (map[row - 1][col] == '*') count ++;
        if (map[row - 1][col + 1] == '*') count ++;
        if (map[row][col - 1] == '*') count ++;
        if (map[row][col + 1] == '*') count ++;
        if (map[row + 1][col - 1] == '*') count ++;
        if (map[row + 1][col] == '*') count ++;
        if (map[row + 1][col + 1] == '*') count ++;
        return count;
    }

    public static void displayMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

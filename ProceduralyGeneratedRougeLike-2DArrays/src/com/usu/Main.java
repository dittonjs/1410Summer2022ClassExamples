package com.usu;

import javax.management.relation.RelationNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // P = player
    // * = wall
    // M = monsters
    // K = key
    // D = door
    public static void main(String[] args) {
        char[][] map = generateLevel();
        Scanner scanner = new Scanner(System.in);
        boolean hasKey = false;
        boolean isAlive = true;
        while(isAlive) {
            displayMap(map);
            String input = scanner.next();
            if (input.equals("done")) {
                break;
            }
            int result = movePlayer(map, input);
            if (result == 1) {
                hasKey = true;
            }
            if (result == 2 && hasKey) {
                map = generateLevel();
                hasKey = false;
                continue;
            }
            isAlive = !moveMonsters(map);
        }
        System.out.println("You ded bro!");
    }

    private static int movePlayer(char[][] map, String input) {
        int nextRow = 0;
        int nextCol = 0;
        for (int row = 0; row < map.length; row ++) {
            for (int col = 0; col < map.length; col ++) {
                if (map[row][col] == 'P') {
                    if (input.equals("w")) {
                        nextRow = row - 1;
                        nextCol = col;
                    }
                    if (input.equals("a")) {
                        nextRow = row;
                        nextCol = col - 1;
                    }
                    if (input.equals("s")) {
                        nextRow =  row + 1;
                        nextCol = col;
                    }
                    if (input.equals("d")) {
                        nextRow = row;
                        nextCol = col + 1;
                    }
                    // key = 1
                    // door = 2
                    // everything else = 0
                    if (map[nextRow][nextCol] == ' ') {
                        map[row][col] = ' ';
                        map[nextRow][nextCol] = 'P';
                        return 0;
                    }
                    if (map[nextRow][nextCol] == 'K') {
                        map[row][col] = ' ';
                        map[nextRow][nextCol] = 'P';
                        return 1;
                    }
                    if (map[nextRow][nextCol] == 'D') {
                        return 2;
                    }
                    break;
                }
            }
        }
        return 0;
    }

    private static boolean moveMonsters(char[][] map) {
        boolean foundPlayer = false;
        for (int row = 0; row < map.length; row ++) {
            for (int col = 0; col < map.length; col ++) {
                if (map[row][col] == 'M') {
                    int nextRow = row;
                    int nextCol = col;
                    if (map[row][col + 1] == 'P') {
                        foundPlayer = true;
                        nextCol = col + 1;
                    } else if(map[row][col - 1] == 'P') {
                        foundPlayer = true;
                        nextCol = col - 1;
                    } else if (map[row + 1][col] == 'P') {
                        foundPlayer = true;
                        nextRow = row + 1;
                    } else if (map[row - 1][col] == 'P') {
                        foundPlayer = true;
                        nextRow = row - 1;
                    } else {
                        Random random = new Random();

                        if (random.nextDouble() < .5) {
                            if (random.nextDouble() < .5) {
                                nextRow = row - 1;
                            } else {
                                nextRow = row + 1;
                            }
                        } else {
                            if (random.nextDouble() < .5) {
                                nextCol = col - 1;
                            } else {
                                nextCol = col + 1;
                            }
                        }
                    }
                    if (map[nextRow][nextCol] == ' ' || map[nextRow][nextCol] == 'P') {
                        map[row][col] = ' ';
                        map[nextRow][nextCol] = 'm';
                    }
                }
            }
        }
        for (int row = 0; row < map.length; row ++) {
            for (int col = 0; col < map.length; col ++) {
                if (map[row][col] == 'm') {
                    map[row][col] = 'M';
                }
            }
        }
        return foundPlayer;
    }

    private static char[][] generateLevel() {
        char[][] map = new char[12][];
        fillMap(map);
        createWalls(map);
        generateInnerWalls(map);
        map = doCellularAutomata(map);
        addStaticElements(map);
        randomlyPlaceElement(map, 'K');
        randomlyPlaceElement(map, 'M');
        randomlyPlaceElement(map, 'M');
        randomlyPlaceElement(map, 'M');
        return map;
    }

    private static void fillMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            map[i] = new char[12];
            Arrays.fill(map[i], ' ');
        }
    }

    private static void createWalls(char[][] map) {
        Arrays.fill(map[0], '*');
        Arrays.fill(map[map.length - 1], '*');
        for (int i = 0; i < map.length; i++) {
            map[i][0] = '*';
            map[i][map[i].length - 1] =  '*';
        }
    }

    private static void generateInnerWalls(char[][] map) {
        Random random = new Random();
        for (int i = 2; i < map.length - 2; i++) {
            for (int j = 2; j < map[i].length - 2; j ++) {
                if (random.nextDouble() < .4) {
                    map[i][j] = '*';
                }
            }
        }
    }
    private static char[][] copyMap(char[][] map) {
        char[][] newMap = new char[map.length][];
        for (int i = 0; i < map.length; i++) {
            newMap[i] = new char[map[i].length];
            System.arraycopy(map[i], 0, newMap[i], 0, map[i].length);
        }
        return newMap;
    }
    private static char[][] doCellularAutomata(char[][] map) {
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

    private static int countNumberOfNeighbors(char[][] map, int row, int col) {
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

    private static void addStaticElements(char[][] map) {
        map[map.length - 2][1] = 'P';
        map[1][map[1].length - 2] = 'D';
    }

    private static void randomlyPlaceElement(char[][] map, char element) {
        Random random = new Random();
        int row = random.nextInt(map.length - 3) + 1;
        int col = random.nextInt(map[0].length - 3) + 1;

        while(map[row][col] != ' ') {
            row ++;
        }
        map[row][col] = element;
    }

    private static void displayMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

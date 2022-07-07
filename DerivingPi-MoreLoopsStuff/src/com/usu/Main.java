package com.usu;


import jdk.jshell.execution.JdiInitiator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
	    // simulation for computing pi
//        for (int i = 1000; i <= 100000000; i*=10) {
//            doMontecarloSimulation(i);
//        }
        int a = 10;
        System.out.println(a);
        timesBy2(a);
        System.out.println(a);
        int[] values = {1,4,6,43,6,435,653,34};
        printArray(values);
        doSomethingWithTheArray(values);
        printArray(values);
    }

    private static void timesBy2(int value) {
        value *= 2;
    }

    private static void doSomethingWithTheArray(int[] data) {
        data = new int[5];
    }

    private static void printArray(int[] data) {
        for(int val : data) {
            System.out.printf("%d, ", val);
        }
        System.out.println();
    }

    private static double computeDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(
                Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );
    }

    private static boolean tryExperiment() {
        Random random = new Random();
        double xPos = random.nextDouble();
        double yPos = random.nextDouble();
        // calculate distance from origin
        double distance = computeDistance(0, 0, xPos, yPos);
        return distance <= 1.0;
    }

    private static void doMontecarloSimulation(int numAttempts) {
        int numSuccess = 0;

        for (int i = 0; i < numAttempts; i++) {
            if (tryExperiment()) {
                numSuccess ++;
            }
        }
        displayResults(computePiFromResult(numSuccess, numAttempts));
    }

    private static double computePiFromResult(int numSuccess, int numAttempts) {
        return ((double)numSuccess / numAttempts) * 4;
    }

    private static void displayResults(double result) {
        System.out.printf("The value for PI is: %.8f\n", result);
    }
}

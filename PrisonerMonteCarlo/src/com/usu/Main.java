package com.usu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int numPrisoners = 100;
        double numSuccesses = 0;
        double numAttempts = 1000;

        for (int i = 0; i < numAttempts; i++) {
            // for each experiment
            int[] boxes = new int[numPrisoners];
            // fill up array with prisoner numbers
            for (int prinsonerNum = 0; prinsonerNum < numPrisoners; prinsonerNum ++) {
                boxes[prinsonerNum] = prinsonerNum;
            }
            // do some magic
            List<Integer> list = Arrays.stream(boxes)
                    .boxed()
                    .collect(Collectors.toList());
            Collections.shuffle(list);
            boxes = list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
            boolean allFound = true;
            for (int prisoner = 0; prisoner < 100; prisoner++) {
                int box = prisoner;
                int checkedBox = boxes[box];
                int attemptNum = 1;
                while(checkedBox != prisoner && attemptNum < 50) {
                    box = checkedBox;
                    checkedBox = boxes[box];
                    attemptNum ++;
                }
                if (checkedBox != prisoner) {
                    allFound = false;
                    break;
                }
            }
            if (allFound) {
                numSuccesses ++;
            }
        }
        double numControlSuccesses = 0;
        double numControlAttempts = 1000;
        for (int i = 0; i < numControlAttempts; i++) {
            // for each experiment
            int[] boxes = new int[numPrisoners];
            // fill up array with prisoner numbers
            for (int prinsonerNum = 0; prinsonerNum < numPrisoners; prinsonerNum ++) {
                boxes[prinsonerNum] = prinsonerNum;
            }
            // do some magic

            boolean allFound = true;
            for (int prisoner = 0; prisoner < 100; prisoner++) {
                List<Integer> list = Arrays.stream(boxes)
                        .boxed()
                        .collect(Collectors.toList());
                Collections.shuffle(list);
                boxes = list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
                int box = 0;
                for (; box < 50; box ++) {
                    if (boxes[box] == prisoner) {
                        break;
                    }
                }
                if (boxes[box] != prisoner) {
                    allFound = false;
                    break;
                }
            }

            if (allFound) {
                numControlSuccesses ++;
            }
        }

        System.out.printf("Odds of prisoners escaping are: %f\n", numSuccesses / numAttempts);
        System.out.printf("Odds of prisoners escaping are: %f\n", numControlSuccesses / numControlAttempts);
    }
}

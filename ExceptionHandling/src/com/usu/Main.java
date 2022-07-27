package com.usu;

import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("type in two ints: ");
            try {
                int int1 = scanner.nextInt();
                int int2 = scanner.nextInt();
                int result = randomMethod(int1, int2);
                System.out.printf("Your result is %d\n", result);
            } catch (DivideByZeroException ex) {
                System.out.println(ex.getMessage());
                // blah do some code
//                throw new InputMismatchException();
            } catch (InputMismatchException ex) {

                System.out.println("One of the values you entered was not an integer.");
            } finally {
                scanner.nextLine();
            }
            System.out.println("Would you like to continue? (y/n)");
            String input = scanner.next();
            if (input.equals("n")) {
                break;
            }
        }
        System.out.println("Thanks for using my program!");
    }

    public static int randomMethod(int value1, int value2) throws DivideByZeroException {
        return randomMethod2(value1, value2);
    }

    public static int randomMethod2(int value1, int value2) throws DivideByZeroException {
        return doDivision(value1, value2);
    }

    public static int doDivision(int value1, int value2) throws DivideByZeroException {
        try {
            return value1 / value2;
        } catch (ArithmeticException exception) {
            throw new DivideByZeroException(value1);
        } finally {
            System.out.println("I GOT RAN");
        }
    }
}

class DivideByZeroException extends Exception {
    private int value;
    public DivideByZeroException(int value) {
        super(String.format("Tried to divide %d by 0", value));
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}



import java.util.HashMap;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type in your name: ");
        String name = scanner.next();
        System.out.print("Type in your age: ");
        int age;
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
        } else {
            System.out.println("Not a valid age");
            return;
        }

        System.out.println(age);

    }
}
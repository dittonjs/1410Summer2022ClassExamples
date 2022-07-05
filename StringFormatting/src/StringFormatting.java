import java.util.Scanner;

public class StringFormatting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.next();

        System.out.print("Enter your age: ");
        int age;
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
        } else {
            System.out.println(scanner.next() + " is not a valid age");
            return;
        }

        System.out.print("Enter your loan term: ");
        int term;
        if (scanner.hasNextInt()) {
            term = scanner.nextInt();
        } else {
            System.out.println(scanner.next() + " is not a term");
            return;
        }
        System.out.print("Enter your salary: ");
        double salary;
        if (scanner.hasNextDouble()) {
            salary = scanner.nextDouble();
        } else {
            System.out.println(scanner.next() + " is not a valid salary");
            return;
        }
        System.out.print("Enter your down payment amount: ");
        double downPayment;
        if (scanner.hasNextDouble()) {
            downPayment = scanner.nextDouble();
        } else {
            System.out.println(scanner.next() + " is not a valid down payment");
            return;
        }
        System.out.print("Enter your interest rate: ");
        double interestRate;
        if (scanner.hasNextDouble()) {
            interestRate = scanner.nextDouble();
        } else {
            System.out.println(scanner.next() + " is not a valid interest rate");
            return;
        }

        System.out.print("Enter your total loan amount: ");
        double loanAmount;
        if (scanner.hasNextDouble()) {
            loanAmount = scanner.nextDouble();
        } else {
            System.out.println(scanner.next() + " is not a valid loan amount");
            return;
        }

        System.out.printf("%-17s %12s\n", "Applicant name:", name);
        System.out.printf("%-17s %12d\n", "Applicant age:", age);
        System.out.printf("%-17s %12d\n", "Loan term:", term);
        System.out.printf("%-17s %12.2f\n", "Salary:", salary);
        System.out.printf("%-17s %12.2f\n", "Down payment:", downPayment);
        System.out.printf("%-17s %12.2f\n", "Interest rate:", interestRate);
        System.out.printf("%-17s %12.2f\n", "Loan amount:", loanAmount);
        double totalAmount = (loanAmount - downPayment);
        double withInterest = totalAmount + (totalAmount * (interestRate / 100));
        double monthlyPayment = withInterest / term / 12;
        // %[flags][args][.precision][var type]
        System.out.printf("%-17s %12.2f\n", "Monthly payment:", monthlyPayment);

    }
}
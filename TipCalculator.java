import java.util.Scanner;
import java.text.DecimalFormat;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Welcome to the Tip Calculator!");
        double billAmount = 0;
        do {
            System.out.print("Enter the bill amount: ");
            if (scanner.hasNextDouble()) {
                billAmount = scanner.nextDouble();
                if (billAmount <= 0) {
                    System.out.println("Bill amount must be greater than zero.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        } while (billAmount <= 0);
        int tipPercentage = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Choose a tip percentage (15, 18, 20, 25): ");
            if (scanner.hasNextInt()) {
                tipPercentage = scanner.nextInt();
                if (tipPercentage == 15 || tipPercentage == 18 || tipPercentage == 20 || tipPercentage == 25) {
                    validInput = true; // Valid percentage, exit loop
                } else {
                    System.out.println("Please choose 15, 18, 20, or 25 as the tip percentage.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        }
        double tipAmount = billAmount * tipPercentage / 100.0;
        double totalAmount = billAmount + tipAmount;
        System.out.println("Calculating...\n");
        System.out.println("Tip amount: $" + df.format(tipAmount));
        System.out.println("Total bill: $" + df.format(totalAmount));
        scanner.close();
    }
}

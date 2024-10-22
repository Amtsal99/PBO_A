import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tipeKopi = {"Espresso", "Latte", "Cappuccino"};
        double[] hargaKopi = {2.50, 3.00, 3.50};

        System.out.println("Welcome to the Coffee Machine!");
        System.out.println("Please select a coffee type:");

        for (int i = 0; i < tipeKopi.length; i++) {
            System.out.println((i + 1) + ". " + tipeKopi[i] + " - $" + hargaKopi[i]);
        }

        System.out.print("Enter the number of your choice: ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= tipeKopi.length) {
            System.out.println("You have selected: " + tipeKopi[choice - 1]);
            System.out.println("Please pay: $" + hargaKopi[choice - 1]);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }
}
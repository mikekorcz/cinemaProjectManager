package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();

        System.out.println();
        System.out.println("Cinema:");
        for (int i = 0; i <= numberOfSeats; i++) {
            if (i == 0) {
                System.out.print("  ");
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        for (int j = 1; j <= numberOfRows; j++) {
            System.out.print(j + " ");
            for (int k = 1; k <= numberOfSeats; k++) {
                System.out.print("S ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        System.out.println();

        int totalCost = numberOfRows * numberOfSeats;
        int ticketTenDollars = 10;
        int ticketEightDollars = 8;

        if (totalCost < 60) {
            System.out.println("Ticket price: " + "$" + ticketTenDollars);
        } else if (totalCost > 60) {

            if (rowNumber <= numberOfRows / 2) {
                System.out.println("Ticket price: " + "$" + ticketTenDollars);
            } else {
                System.out.println("Ticket price: " + "$" + ticketEightDollars);
            }

            System.out.println();
        }

        System.out.println("Cinema:");
        for (int i = 0; i <= numberOfSeats; i++) {
            if (i == 0) {
                System.out.print("  ");
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        for (int j = 1; j <= numberOfRows; j++) {
            System.out.print(j + " ");
            for (int k = 1; k <= numberOfSeats; k++) {
                if (j == rowNumber && k == seatNumber) {
                    System.out.print("B ");
                    continue;
                }
                System.out.print("S ");
            }
            System.out.println();
        }
    }
}

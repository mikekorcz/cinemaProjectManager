package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {

//        // STAGE 1/5 = creating cinema theatre
//        System.out.println("Cinema:");
//        System.out.println("  1 2 3 4 5 6 7 8");
//        for (int i = 1; i <= 7; i++)
//            System.out.println(i + " " + "S ".repeat(8).trim());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        int totalCost = numberOfRows * numberOfSeats;

        if (totalCost <= 60) {
            totalCost *= 10;
        } else if (totalCost > 60) {
            if (numberOfRows % 2 == 0) {
                int frontRows = (numberOfRows / 2 * numberOfSeats) * 10;
                int backRows = (numberOfRows / 2 * numberOfSeats) * 8;
                totalCost = frontRows + backRows;
            } else if (numberOfRows % 2 != 0) {
                int frontRows = ((numberOfRows - 1) / 2 * numberOfSeats) * 10;
                int backRows = ((numberOfRows + 1) / 2 * numberOfSeats) * 8;
                totalCost = frontRows + backRows;
            }
        }
        System.out.println("Total income:");
        System.out.println("$" + totalCost);

    }
}

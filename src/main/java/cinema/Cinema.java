package cinema;
import java.text.NumberFormat;
import java.util.Scanner;

public class Cinema {

    private static char[][] cinemaTheatre;
    private static final int normalTicketPrice = 10;
    private static final int ticketPriceFrontHalf = 10;
    private static final int ticketPriceBackHalf = 8;

    private static final char SEAT = 'S';
    private static final char BUSY = 'B';

    private static int numberOfPurchasedTickets;
    private static int currentIncome;
    private static int totalIncome;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        createCinemaTheatre();
        int command;
        do {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            command = scanner.nextInt();
            System.out.println();
            switch (command) {
                case 1:
                    printCinemaHall(cinemaTheatre);
                    break;
                case 2:
                    takeTicket(cinemaTheatre);
                    break;
                case 3:
                    showStatistics(cinemaTheatre);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Error! Wrong command!");
            }
        } while (command != 0);
    }

    public static void createCinemaTheatre() {
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();

        cinemaTheatre = new char[numberOfRows][numberOfSeats];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeats; j++) {
                cinemaTheatre[i][j] = SEAT;
            }
        }

        int totalNumOfSeats = cinemaTheatre.length * cinemaTheatre[0].length;
        if (totalNumOfSeats <= 60) {
            totalIncome = totalNumOfSeats * normalTicketPrice;
        } else {
            int frontHalfOfRows = cinemaTheatre.length / 2;
            int totalFrontHalf = frontHalfOfRows * cinemaTheatre[0].length * ticketPriceFrontHalf;
            int totalBackHalf = (cinemaTheatre.length - frontHalfOfRows) * cinemaTheatre[0].length * ticketPriceBackHalf;
            totalIncome = totalFrontHalf + totalBackHalf;
        }
    }

    public static void printCinemaHall(char[][] cinemaTheatre) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinemaTheatre[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < cinemaTheatre.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinemaTheatre[0].length; j++) {
                System.out.print(" " + cinemaTheatre[i][j]);
            }
            System.out.println();
        }
    }

    public static void takeTicket(char[][] cinemaTheatre) {
        int totalNumberOfSeats = cinemaTheatre.length * cinemaTheatre[0].length;

        int seatRow;
        int seatNumber;

        while (true) {
            System.out.println("Enter a row number:");
            seatRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt();
            if (seatRow > cinemaTheatre.length || seatNumber > cinemaTheatre[0].length) {
                System.out.println("Wrong input!");
            } else {
                if (cinemaTheatre[seatRow - 1][seatNumber - 1] == BUSY) {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    break;
                }
            }
        }

        int priceTicket;

        if (totalNumberOfSeats <= 60) {
            priceTicket = normalTicketPrice;
            totalIncome = totalNumberOfSeats * priceTicket;
        } else {
            int frontHalfOfRows = cinemaTheatre.length / 2;
            if (seatRow <= frontHalfOfRows) {
                priceTicket = ticketPriceFrontHalf;
            } else {
                priceTicket = ticketPriceBackHalf;
            }
        }

        currentIncome += priceTicket;
        numberOfPurchasedTickets++;

        System.out.println("Ticket price: $" + priceTicket);
        cinemaTheatre[seatRow - 1][seatNumber - 1] = BUSY;
    }

    private static void showStatistics(char[][] cinemaTheatre) {

        float totalNumOfSeats = cinemaTheatre.length * cinemaTheatre[0].length;
        float percentageOfPurchased = 100 / totalNumOfSeats * numberOfPurchasedTickets;

        System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%s%n", percentageOfPurchased, "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}
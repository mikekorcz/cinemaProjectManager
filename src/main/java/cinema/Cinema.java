package cinema;

import java.util.Scanner;

public class Cinema {

    private static char[][] cinemaTheatre;
    private static final int normalTicketPrice = 10;
    private static final int ticketPriceFrontHalf = 10;
    private static final int ticketPriceBackHalf = 8;

    private static final char SEAT = 'S';
    private static final char BUSY = 'B';

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        createCinemaTheatre();
        int command;
        do {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
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

        System.out.println("Enter a row number:");
        int seatRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        int priceTicket;

        if (totalNumberOfSeats <= 60) {
            priceTicket = normalTicketPrice;
        } else {
            int frontHalfOfRows = cinemaTheatre.length / 2;
            if (seatRow <= frontHalfOfRows) {
                priceTicket = ticketPriceFrontHalf;
            } else {
                priceTicket = ticketPriceBackHalf;
            }
        }

        System.out.println("Ticket price: $" + priceTicket);
        cinemaTheatre[seatRow - 1][seatNumber - 1] = BUSY;
    }
}
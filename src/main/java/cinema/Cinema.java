package cinema;

public class Cinema {
    public static void main(String[] args) {
        // creating cinema theatre
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 1; i <= 7; i++)
            System.out.println(i + " " + "S ".repeat(8).trim());
    }
}

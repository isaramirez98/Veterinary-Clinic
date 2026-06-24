package ui;
import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);
     public static void writeLine(Object message) {
        System.out.println(message);
    }

    public static String readLine(String propmt) {
        System.out.println(propmt);
        return scanner.nextLine();

    }
}

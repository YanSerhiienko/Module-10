package homework;

import java.io.*;
import java.util.Scanner;

public class PhonePrinter {
    public void printPhones(File file) {
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while ((scanner.hasNextLine())) {
                String line = scanner.nextLine();
                if (line.matches("[\\d]{3}-[\\d]{3}-[\\d]{4}") || line.matches("\\(\\d{3}\\)\\s[\\d]{3}-[\\d]{4}")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

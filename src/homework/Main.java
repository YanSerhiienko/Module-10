package homework;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        new PhonePrinter().printPhones(new File("./resources/homework-txt/phones"));

        new UserToJson().toJson(new File("./resources/homework-txt/users"));

        new WordPrinter().printWords(new File("./resources/homework-txt/words"));

    }

}

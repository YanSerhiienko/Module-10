package homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;


public class UserToJson {
    public void toJson(File file) {
        convert(read(file));
    }

    private String read(File file) {
        StringBuilder resultBuilder = new StringBuilder("[\n");
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            String[] columnName = scanner.nextLine().split("\\s");
            String[] columnContent;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                columnContent = line.split("\\s");
                resultBuilder.append("    {\n" + "        " + "\"" + columnName[0] + "\": \"" + columnContent[0] + "\",\n" + "        \"" + columnName[1] + "\": " + columnContent[1] + "\n" + "    },\n");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return resultBuilder.substring(0, resultBuilder.length() - 2) + "\n]";
    }

    private static void convert(String result) {
        File file = new File("./ConvertationResult/users.json");

        checkIfFileAvailable(file);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(result);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void checkIfFileAvailable(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();

            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}



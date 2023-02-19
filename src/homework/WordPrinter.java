package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class WordPrinter {
    private ArrayList<String> wordsToPrint = new ArrayList<>();
    private ArrayList<Integer> wordsAmount = new ArrayList<>();

    public void printWords(File file) {
        save(read(file));
        print();
    }

    private String[] read(File file) {
        StringBuilder allWordsBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while ((scanner.hasNextLine())) {
                String line = scanner.nextLine();
                allWordsBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return allWordsBuilder.toString().trim().split("\\s+");
    }

    private void save(String[] allWordsArr) {
        while (allWordsArr.length > 0) {
            int wordCounter = 1;
            String wordToCompare = allWordsArr[0];

            System.arraycopy(allWordsArr, 1, allWordsArr, 0, allWordsArr.length - 1);
            allWordsArr = Arrays.copyOfRange(allWordsArr, 0, allWordsArr.length - 1);

            for (int i = 0; i < allWordsArr.length; i++) {
                if(wordToCompare.contains(allWordsArr[i])) {
                    wordCounter++;
                    System.arraycopy(allWordsArr, i+1, allWordsArr, i, allWordsArr.length - i - 1);
                    allWordsArr = Arrays.copyOfRange(allWordsArr, 0, allWordsArr.length - 1);
                    i--;
                }
            }
            wordsToPrint.add(wordToCompare);
            wordsAmount.add(wordCounter);
        }
    }

    private void print() {
        while(wordsToPrint.size() > 0) {
            int biggestAmount = 0;
            int indexToRemove = 0;
            for (int i = 0; i < wordsToPrint.size(); i++) {
                if (wordsAmount.get(i) >= biggestAmount) {
                    biggestAmount = wordsAmount.get(i);
                    indexToRemove = i;
                }
            }
            System.out.println(wordsToPrint.get(indexToRemove) + " " + wordsAmount.get(indexToRemove));
            wordsToPrint.remove(indexToRemove);
            wordsAmount.remove(indexToRemove);
        }
    }
}

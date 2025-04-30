import main.org.csg.cw.api.WordCounter;
import main.org.csg.cw.api.WordListGetter;
import main.org.csg.cw.impl.WordCounterImpl;
import main.org.csg.cw.impl.WordListGetterImpl;
import main.org.csg.cw.util.InputReader;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a input file path name. Use \"src/resources/input.txt\" for already curated input file : ");
        String filePath = scanner.nextLine();

        System.out.println("Enter the comma separated starting letter for string search eg M,m: ");
        String startingWordsStr = scanner.nextLine();
        String[] startingWordsStrArr = startingWordsStr.split(",");

        System.out.println("Enter the length of Word String to be returned eg 5: ");
        int lengthOfWord = scanner.nextInt();
        scanner.close();

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Results are follows:");
        System.out.println("---------------------------------------------------------------------");

        long count  = getWordCount(filePath, startingWordsStrArr);
        List<String> resultList  = getWordsWithLengthMoreThan(filePath, lengthOfWord);

        System.out.println("Count of words starting with letters " + Arrays.toString(startingWordsStrArr) + " is: " + count);
        System.out.println("List of words with length more then " + lengthOfWord + " are: " + resultList);
        System.out.println("---------------------------------------------------------------------");
    }

    public static long getWordCount(String filePath, String[] startingWordsStrArr){
        List<String> inputStringList = InputReader.readFromFile(filePath);
        WordCounter wordCounter = new WordCounterImpl();
        return wordCounter.wordCount(inputStringList, startingWordsStrArr);
    }

    public static List<String> getWordsWithLengthMoreThan(String filePath, int length){
        List<String> inputStringList = InputReader.readFromFile(filePath);
        WordListGetter wlg = new WordListGetterImpl();
        return wlg.getWordsWithLengthMoreThan(inputStringList, length);
    }
}
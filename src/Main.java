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

        String filePath = getFilePath(scanner);
        String[] startingWordsStrArr = getStartingWords(scanner);
        int lengthOfWord = getLengthOfWord(scanner);
        closeScanner(scanner);

        printResult(filePath, startingWordsStrArr, lengthOfWord);

    }

    /**
     * Closes scanner
     * @param scanner
     */
    private static void closeScanner(Scanner scanner) {
        scanner.close();
    }

    /**
     * @param scanner
     * @return input word length
     */
    private static int getLengthOfWord(Scanner scanner) {
        System.out.println("Enter the length of Word String to be returned eg 5: ");
        return scanner.nextInt();
    }

    /**
     * @param scanner
     * @return string array containing starting letters which are to be searched from the given spring pool
     */
    private static String[] getStartingWords(Scanner scanner) {
        System.out.println("Enter the comma separated starting letter for string search eg M,m: ");
        String startingWordsStr = scanner.nextLine();
        String[] startingWordsStrArr = startingWordsStr.split(",");
        for(int i = 0; i< startingWordsStrArr.length; i++){
            startingWordsStrArr[i] = startingWordsStrArr[i].trim();
        }
        return startingWordsStrArr;
    }

    /**
     * @param scanner
     * @return file path of spring pool to analyse
     */
    private static String getFilePath(Scanner scanner){
        System.out.println("Enter a input file path name. Use \"src/resources/input.txt\" for already curated input file : ");
        return scanner.nextLine();
    }

    /**
     * Fetch and prints the result which is taken from @getWordCount
     * @param filePath: file path of spring pool to analyse
     * @param startingWordsStrArr: string array containing starting letters which are to be searched from the given spring pool
     * @param lengthOfWord: input word length
     */
    private static void printResult(String filePath, String[] startingWordsStrArr, int lengthOfWord){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Results are follows:");
        System.out.println("---------------------------------------------------------------------");

        long count  = getWordCount(filePath, startingWordsStrArr);
        List<String> resultList  = getWordsWithLengthMoreThan(filePath, lengthOfWord);

        System.out.println("Count of words starting with letters " + Arrays.toString(startingWordsStrArr) + " is: " + count);
        System.out.println("List of words with length more then " + lengthOfWord + " are: " + resultList);
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * @param filePath
     * @param startingWordsStrArr
     * @return count of words in filePath which are starting with letters mentioned in startingWordsStrArr
     */
    private static long getWordCount(String filePath, String[] startingWordsStrArr){
        List<String> inputStringList = InputReader.readFromFile(filePath);
        WordCounter wordCounter = new WordCounterImpl();
        return wordCounter.wordCount(inputStringList, startingWordsStrArr);
    }

    /**
     * @param filePath
     * @param lengthWord
     * @return words from filePath whose length is more then given lengthWord
     */
    private static List<String> getWordsWithLengthMoreThan(String filePath, int lengthWord){
        List<String> inputStringList = InputReader.readFromFile(filePath);
        WordListGetter wlg = new WordListGetterImpl();
        return wlg.getWordsWithLengthMoreThan(inputStringList, lengthWord);
    }
}

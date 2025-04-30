package test.org.csg.cw.impl;

import main.org.csg.cw.api.WordCounter;
import main.org.csg.cw.impl.WordCounterImpl;
import main.org.csg.cw.util.InputReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterImplTest {

    @Test
    void wordCount() {
        String filePath = "src/resources/testinput.txt";
        String[] startingWord = new String[]{"M", "m"};
        List<String> inputStringList = InputReader.readFromFile(filePath);
        WordCounter counter = new WordCounterImpl();
        long actualCount = counter.wordCount(inputStringList, startingWord);

        assertEquals(5, actualCount);
    }
}
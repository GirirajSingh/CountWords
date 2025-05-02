package test.org.csg.cw.impl;


import main.org.csg.cw.api.WordListGetter;
import main.org.csg.cw.impl.WordListGetterImpl;
import main.org.csg.cw.util.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

class WordListGetterImplTest {

    @Test
    void getWordsWithLengthMoreThan() {
        String filePath = "src/resources/testinput.txt";
        int length = 5;
        List<String> inputStringList = InputReader.readFromFile(filePath);
        WordListGetter wlg = new WordListGetterImpl();
        List<String> actualList = wlg.getWordsWithLengthMoreThan(inputStringList, length);
        List<String> expectedList = List.of("process", "sensitive");

        Assertions.assertTrue(expectedList.containsAll(actualList));
        Assertions.assertTrue(actualList.containsAll(expectedList));
    }
}

package test.org.csg.cw.util;

import main.org.csg.cw.exception.ReaderException;
import main.org.csg.cw.util.InputReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    @Test
    void failOnWrongPath() {
        String filePath = "abc";
        assertThrows(ReaderException.class, () -> InputReader.readFromFile(filePath));
    }

    @Test
    void doNotFailOnCorrectPath() {
        String filePath = "src/resources/testinput.txt";
        assertDoesNotThrow(() -> InputReader.readFromFile(filePath));
    }
}
package main.org.csg.cw.util;

import main.org.csg.cw.exception.ReaderException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputReader {
    private static final Logger logger = Logger.getLogger(InputReader.class.getName());

    /**
     * @param path: path of the file with input strings
     * @return: the strings in list form
     */
    public static List<String> readFromFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferreader.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "File not Found " + ex.getMessage(), ex);
            throw new ReaderException(ex.getMessage());
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IO Exception " + ex.getMessage(), ex);
            throw new ReaderException(ex.getMessage(), ex);
        }
        return list;
    }

}

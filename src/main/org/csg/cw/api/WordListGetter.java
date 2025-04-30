package main.org.csg.cw.api;

import java.util.List;

public interface WordListGetter {
    List<String> getWordsWithLengthMoreThan(List<String> inputList, int length);
}

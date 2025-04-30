package main.org.csg.cw.impl;

import main.org.csg.cw.api.WordListGetter;

import java.util.List;
import java.util.stream.Collectors;

public class WordListGetterImpl implements WordListGetter {

    /**
     * @param inputList: input word list
     * @param length: the minimum length of word which are needed in output
     * @return: list of strings whose length is more then the prescribed length
     */
    @Override
    public List<String> getWordsWithLengthMoreThan(List<String> inputList, int length) {
        return inputList.stream().filter(a -> a.length()>length).collect(Collectors.toList());
    }
}

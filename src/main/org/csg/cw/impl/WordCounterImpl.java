package main.org.csg.cw.impl;

import main.org.csg.cw.api.WordCounter;

import java.util.Arrays;
import java.util.List;

public class WordCounterImpl implements WordCounter {
    /**
     * @param list: input word list
     * @param startStrs: the list of starting characters to match from
     * @return: number of words from input string which are matching with startStrs
     */
    @Override
    public long wordCount(List<String> list, String[] startStrs) {
        return list.stream().filter(
                str -> {
                    return Arrays.stream(startStrs).anyMatch(str::startsWith);
                }
        ).count();
    }
}

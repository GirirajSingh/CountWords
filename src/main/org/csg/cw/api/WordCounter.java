package main.org.csg.cw.api;

import java.util.List;

public interface WordCounter {
    long wordCount(List<String> list, String[] startStr);
}

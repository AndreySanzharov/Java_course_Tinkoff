package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static <T> Map<T, Integer> freqDict(List<T> input) {
        Map<T, Integer> dictionary = new HashMap<>();

        for (T element : input){
            dictionary.put(element, dictionary.getOrDefault(element, 0) + 1);
        }
        return dictionary;
    }
}

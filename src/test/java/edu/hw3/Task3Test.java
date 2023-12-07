package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    public void first() {
        List<String> input = List.of("a", "bb", "a", "bb");
        Map<String, Integer> result = Task3.freqDict(input);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 2);
        expected.put("bb", 2);

        assertEquals(expected, result);
    }

    @Test
    public void second() {
        List<String> input = List.of("this", "and", "that", "and");
        Map<String, Integer> result = Task3.freqDict(input);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("this", 1);
        expected.put("and", 2);
        expected.put("that", 1);

        assertEquals(expected, result);
    }

    @Test
    public void third() {
        List<String> input = List.of("код", "код", "код", "bug");
        Map<String, Integer> result = Task3.freqDict(input);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("код", 3);
        expected.put("bug", 1);

        assertEquals(expected, result);
    }
    @Test
    public void fourth(){
        List<Integer> input = List.of(1, 1, 2, 2);
        Map<Integer, Integer> result = Task3.freqDict(input);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 2);

        assertEquals(expected, result);
    }
}

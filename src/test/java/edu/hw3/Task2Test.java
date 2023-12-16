package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    @DisplayName("hooks test")
    public void testClusterize() {
        String input1 = "()()()";
        String input2 = "((()))";
        String input3 = "((()))(())()()(()())";
        String input4 = "((())())(()(()()))";

        List<String> result1 = Task2.clusterize(input1);
        List<String> result2 = Task2.clusterize(input2);
        List<String> result3 = Task2.clusterize(input3);
        List<String> result4 = Task2.clusterize(input4);

        assertEquals(List.of("\"()\"", "\"()\"", "\"()\""), result1);
        assertEquals(List.of("\"((()))\""), result2);
        assertEquals(List.of("\"((()))\"", "\"(())\"", "\"()\"", "\"()\"", "\"(()())\""), result3);
        assertEquals(List.of("\"((())())\"", "\"(()(()()))\""), result4);
    }
}


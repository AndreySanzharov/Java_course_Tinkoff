package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        StringBuilder cluster = new StringBuilder();
        int balance = 0;
        final String error = "not balanced";

        for (char character : input.toCharArray()) {
            if (character == '(') {
                balance++;
            } else if (character == ')') {
                balance--;
            }

            cluster.append(character);

            if (balance == 0) {
                clusters.add('"' + cluster.toString() + '"');
                cluster = new StringBuilder();
            }
        }
        return clusters;
    }
}

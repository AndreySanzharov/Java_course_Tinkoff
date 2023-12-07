package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {

    @Test
    void comparatorTest() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
}

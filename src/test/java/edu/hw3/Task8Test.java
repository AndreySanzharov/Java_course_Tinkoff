package edu.hw3;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {

    @Test
    public void testBackwardIterator() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Task8.BackwardIterator<Integer> iterator = new Task8.BackwardIterator<>(list);

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());

        assertFalse(iterator.hasNext());
    }

}


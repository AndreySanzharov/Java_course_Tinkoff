package edu.hw3;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test(expected = java.util.NoSuchElementException.class)
    public void testBackwardIteratorEmpty() {
        List<Integer> list = Arrays.asList();
        Task8.BackwardIterator<Integer> iterator = new Task8.BackwardIterator<>(list);

        assertFalse(iterator.hasNext());
        iterator.next(); // Тут ожидается исключение NoSuchElementException
    }
}


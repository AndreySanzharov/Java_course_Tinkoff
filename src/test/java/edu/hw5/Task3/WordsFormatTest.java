package edu.hw5.Task3;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordsFormatTest {
    @Test
    void testToday() {
        Optional<LocalDate> result = WordsFormat.WordsparseDate("today");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now(), result.get());
    }

    @Test
    void testTomorrow() {
        Optional<LocalDate> result = WordsFormat.WordsparseDate("tomorrow");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now().plusDays(1), result.get());
    }

    @Test
    void testYesterday() {
        Optional<LocalDate> result = WordsFormat.WordsparseDate("yesterday");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now().minusDays(1), result.get());
    }

    @Test
    void testInvalidInput() {
        Optional<LocalDate> result = WordsFormat.WordsparseDate("invalid");
        assertFalse(result.isPresent());
    }
}

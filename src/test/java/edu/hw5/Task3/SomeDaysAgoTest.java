package edu.hw5.Task3;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomeDaysAgoTest {
    @Test
    void testOneDayAgo() {
        SomeDaysAgo parser = new SomeDaysAgo();
        Optional<LocalDate> result = parser.parse("1 day ago");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now().minusDays(1), result.get());
    }

    @Test
    void testSeveralDaysAgo() {
        SomeDaysAgo parser = new SomeDaysAgo();
        Optional<LocalDate> result = parser.parse("5 days ago");
        assertTrue(result.isPresent());
        assertEquals(LocalDate.now().minusDays(5), result.get());
    }

    @Test
    void testInvalidInput() {
        SomeDaysAgo parser = new SomeDaysAgo();
        Optional<LocalDate> result = parser.parse("invalid");
        assertFalse(result.isPresent());
    }
}

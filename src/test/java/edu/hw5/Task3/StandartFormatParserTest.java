package edu.hw5.Task3;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StandartFormatParserTest {
    @Test
    void testValidDateFormats() {
        Optional<LocalDate> result1 = StandartFormatParser.StandartparseDate("2020-10-10");
        assertEquals(LocalDate.of(2020, 10, 10), result1.orElseThrow());

        Optional<LocalDate> result2 = StandartFormatParser.StandartparseDate("1/3/1976");
        assertEquals(LocalDate.of(1976, 3, 1), result2.orElseThrow());

        Optional<LocalDate> result3 = StandartFormatParser.StandartparseDate("2020-12-2");
        assertEquals(LocalDate.of(2020, 12, 2), result3.orElseThrow());
    }

    @Test
    void testInvalidDateFormats() {
        Optional<LocalDate> result = StandartFormatParser.StandartparseDate("invalid");
        assertFalse(result.isPresent());
    }
}

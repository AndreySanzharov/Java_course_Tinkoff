package edu.hw5;

import edu.hw5.Task1;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("пустой список")
    public void Empty() {
        // Тест на пустой список
        List<String> emptyList = new ArrayList<>();
        String expectedEmptyResult = "Список пуст";
        assertEquals(expectedEmptyResult, Task1.calculatingDuration(emptyList));

    }

    @Test
    @DisplayName("корректный ввод")
    public void Correct() {
        List<String> validList = new ArrayList<>();
        validList.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        validList.add("2022-04-01, 21:30 - 2022-04-02, 01:20");
        String expectedValidResult = "3ч 40м";
        assertEquals(expectedValidResult, Task1.calculatingDuration(validList));
    }

    @Test
    @DisplayName("неверный формат")
    public void wrong() {
        // Тест на ошибку при разборе времени
        List<String> parseErrorList = new ArrayList<>();
        parseErrorList.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        parseErrorList.add("invalid-time - 2022-04-02, 01:20"); // Неверное время
        String expectedParseErrorResult = "Ошибка при обработке временного интервала: invalid-time - 2022-04-02, 01:20";
        assertEquals(expectedParseErrorResult, Task1.calculatingDuration(parseErrorList));
    }

    @Test
    @DisplayName("проверка на null")
    public void nullList() {
        String expectedNullResult = "Список временных интервалов пуст";
        assertEquals(expectedNullResult, Task1.calculatingDuration(null));
    }

}

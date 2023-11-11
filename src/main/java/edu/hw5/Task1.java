package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static String calculatingDuration(List<String> times) {
        if (times == null) {
            return "Список временных интервалов пуст";
        }


        List<Integer> differences = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        for (String time : times) {
            String[] parts = time.split(" - ");

            if (parts.length != 2) {
                return "Неверный формат временного интервала: " + time;
            }
            try{
            LocalDateTime parseTime = LocalDateTime.parse(parts[0], formatter);
            LocalDateTime parseTime2 = LocalDateTime.parse(parts[1], formatter);
            Duration diff = Duration.between(parseTime, parseTime2);
            differences.add(Integer.parseInt(String.valueOf(diff.toMinutes())));
            }catch (Exception e){
                return "Ошибка при обработке временного интервала: " + time;
            }
        }

        if (differences.isEmpty()) {
            return "Список временных интервалов пуст";
        }

        int middle = (differences.stream().mapToInt(Integer::intValue).sum()) / differences.size();
        Integer hours = middle / 60;
        Integer minutes = middle % 60;
        return String.format("%dч %dм", hours, minutes);

    }
}



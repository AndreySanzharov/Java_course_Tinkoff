package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public Pattern SPECIAL_SYMBOL_PATTERN = Pattern.compile("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$");
    public boolean CorrectNumber(String number) {
        Matcher matcher = SPECIAL_SYMBOL_PATTERN.matcher(number);
        return matcher.matches();
    }
}

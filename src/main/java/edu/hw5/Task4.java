package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"MemberName", "MethodName"})
public class Task4 {
    public Pattern SPECIAL_SYMBOL_PATTERN = Pattern.compile("[~!@#$%^&*|]");

    public boolean CorrectOrNot(String password) {
        Matcher matcher = SPECIAL_SYMBOL_PATTERN.matcher(password);
        return matcher.find();
    }
}

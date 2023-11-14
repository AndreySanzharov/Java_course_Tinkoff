package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public boolean findSubString(String string, String subString) {
        Pattern pattern = Pattern.compile(subString);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}

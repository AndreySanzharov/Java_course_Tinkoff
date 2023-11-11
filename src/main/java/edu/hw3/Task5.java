package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task5 {
    public static List<String> parseContacts(String[] names, String order) {
        List<String> contacts = new ArrayList<>();

        if (names != null) {
            Collections.addAll(contacts, names);

            if (order.equals("ASC")) {
                Collections.sort(contacts);
            } else if (order.equals("DESC")) {
                Collections.sort(contacts, Collections.reverseOrder());
            }
        }
        return contacts;
    }
}


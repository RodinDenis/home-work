package com.sbrf.reboot;

import com.sbrf.reboot.utils.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("[");

        strings.add("{");
        strings.add("clientId : 123,");
        strings.add("number : 123");
        strings.add("}");

        strings.add("{");
        strings.add("clientId : 123,");
        strings.add("number : 124");
        strings.add("}");

        strings.add("{");
        strings.add("clientId : 122,");
        strings.add("number : 124");
        strings.add("}");

        strings.add("]");
        HashMap<Integer, Set<String>> parsed = JsonParser.parseAccount(strings);
        System.out.println(parsed.toString());
    }
}

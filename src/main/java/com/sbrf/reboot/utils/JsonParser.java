package com.sbrf.reboot.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsonParser {
    public static HashMap<Integer,Set<String>> parseAccount (List<String> dataStrings) {
        HashMap<Integer, Set<String>> parsedData = new HashMap<>();
        Integer newClientId = null;
        String newAccount = null;
        for (String string : dataStrings) {
            if (string.contains("{")) {
                System.out.println("начало нового объекта : {");
                newClientId = null;
                newAccount = null;
                continue;
            }
            if (string.contains("clientId")) {
                newClientId = Integer.parseInt(string.substring(string.indexOf(":")+1,string.indexOf(",")));
                System.out.println("считали id клиента: " + newClientId);
            }
            if (string.contains("number")) {
                newAccount = string.substring(string.indexOf(":")).trim();
                System.out.println("Номер счета: " + newAccount);
            }
            if(newClientId != null && newAccount != null) {
                if(parsedData.containsKey(newClientId)) {
                    Set<String> accounts = new HashSet<String>();
                    accounts.add(newAccount);
                    parsedData.put(newClientId,accounts);
                }
                else {
                    parsedData.get(newClientId).add(newAccount);
                }
            }
            else {
                System.out.println("Что-то где-то пропало: " + newClientId.toString() + newAccount.toString());
            }
            if (string.contains("}")) {
                System.out.println("окончание объекта : }");
                newClientId = null;
                newAccount = null;
                continue;
            }
        }
        return parsedData;
    }
}

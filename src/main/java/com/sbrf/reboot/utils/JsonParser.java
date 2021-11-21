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
        int clientIterator = 0;
        int accountIterator = 0;
        for (String string : dataStrings) {
            if (string.contains("{")) {
                System.out.println("начало нового объекта : {");
                newClientId = null;
                newAccount = null;
                continue;
            }
            if (string.contains("clientId")) {
                newClientId = Integer.parseInt(string.substring(string.indexOf(":")+2,string.indexOf(",")).trim());
                System.out.println("считали id клиента: " + newClientId);
                clientIterator++;
            }
            if (string.contains("number")) {
                newAccount = string.substring(string.indexOf(":")+3).replace('"',' ').trim();
                System.out.println("Номер счета: " + newAccount); /* тут кибербеза падает в обморок от вывода данных в лог */
                accountIterator++;
            }
            if (string.contains("}")) {
                if(newClientId != null && newAccount != null) {
                    if(!parsedData.containsKey(newClientId)) {
                        Set<String> accounts = new HashSet<String>();
                        accounts.add(newAccount);
                        parsedData.put(newClientId,accounts);
                    }
                    else {
                        parsedData.get(newClientId).add(newAccount);
                    }
                }
                else if (clientIterator == accountIterator && clientIterator != 0) {
                    System.out.println("Что-то где-то пропало!" );
                }
                System.out.println("окончание объекта : }");
                newClientId = null;
                newAccount = null;
                continue;
            }
        }
        return parsedData;
    }
}

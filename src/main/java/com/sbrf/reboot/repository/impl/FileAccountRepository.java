package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.repository.AccountRepository;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileAccountRepository implements AccountRepository {

    private String filePath;

    public FileAccountRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) {
        Set<Long> numbersOfContracts;
        numbersOfContracts = read().get(clientId);

        return numbersOfContracts;
    }

    @SneakyThrows
    private Map<Long, Set<Long>> read() {
        Map<Long, Set<Long>> clients = new HashMap<>();
        Set<Long> numbersOfContracts;
        String line;
        String keyLine;
        String valueLine;
        Long key;
        Long value;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            while ((line = reader.readLine()) != null) {
                if (line.contains("clientId")) {

                    keyLine = line.split("\"clientId\": ")[1].split(",")[0];
                    valueLine = reader.readLine().split("\"number\": ")[1];
                    key = Long.parseLong(keyLine, 10);
                    value = Long.parseLong(valueLine, 10);


                    if (!clients.containsKey(key)) {
                        numbersOfContracts = new HashSet<>();
                        numbersOfContracts.add(value);
                        clients.put((key), numbersOfContracts);
                    } else {
                        clients.get(key).add(value);
                    }

                }

            }
        }

        return clients;
    }

}

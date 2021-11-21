package com.sbrf.reboot.account.repository;

import com.sbrf.reboot.account.entity.Account;
import com.sbrf.reboot.utils.JsonParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class AccountRepositoryImpl implements AccountRepository{
    /**
     * Карта существующих аккаунтов по клиентам
     */
    private HashMap<Integer, HashSet<Account>> clientAccounts;
    /**
     * Сиквенс для идентификаторов (так как предполягается удаление, не могу считать размер множества для получения нового Id
     * + подсчет размера может оказать влияние на производительность, если аккаунтов будет много)
     */
    private int sequenceId;

    public AccountRepositoryImpl() {
        clientAccounts = new HashMap<>();
        sequenceId = 0;
    }

    /**
     * Инициализация репозитория на основе файла
     * @param path Путь до файла с клиентами и их счетами
     */
    public AccountRepositoryImpl(String path) throws FileNotFoundException {
        clientAccounts = new HashMap<>();
        sequenceId = 0;
        try(InputStream inputStream = new FileInputStream(path);
            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(inputStream))) {
            /* читаем файл в массив строк*/

            List<String> readStrings = new ArrayList<>();
            String newReadString = "";
            while(bufferedReader.ready()) {
                newReadString = bufferedReader.readLine();
                readStrings.add(newReadString);
            }

            /* передаем набор строк на парсинг */

            HashMap<Integer,Set<String>> parsedData = JsonParser.parseAccount(readStrings);

            /* создаем новые счета и записываем их в нашу мапу */
            for (Integer clientId : parsedData.keySet()) {
                for (String accountId : parsedData.get(clientId)) {
                    this.newAccount(accountId,clientId);
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
            throw  new FileNotFoundException();
        } finally {
            sequenceId = clientAccounts.size();
        }
    }

    private int nextVal() {
        return ++sequenceId;
    }

    /**
     * Получение всех аккаунтов клиента
     * @param clientId идентификатор клиента
     * @return набор аккаунтов клиента
     */
    public HashSet<Account> getAllAccountsByClientId (Integer clientId) {
        return clientAccounts.get(clientId);
    }

    /**
     * Создание аккаунта - для внешних вызовов
     * @param clientId идентификатор клиента, для которого создается параметр
     */
    public Account newAccount(Integer clientId) {
        Account account = new Account((String.valueOf(this.nextVal())),clientId);
        this.addClientAccount(clientId,account);
        return account;
    }
    /**
     * Создание аккаунта - для внутренних вызовов
     * @param accountId идентафикатор счета
     * @param clientId идентификатор клиента
     */
    private Account newAccount(String accountId, Integer clientId) {
        Account account = new Account(accountId,clientId);
        this.addClientAccount(clientId,account);
        return account;
    }

    /**
     * Добавление нового счета пользователя в список его счетов
     * @param clientId идентификатор клиента
     * @param account счет для добавления в список
     */
    private void addClientAccount (Integer clientId,Account account) {
        if(clientAccounts.containsKey(clientId)) {
            clientAccounts.get(clientId).add(account);
        }
        else {
            HashSet<Account> newClientAccounts = new HashSet<>();
            newClientAccounts.add(account);
            clientAccounts.put(clientId,newClientAccounts);
        }
    }

    /**
     * Удаление аккаунта
     * @param account аккаунт для удаления
     */
    public void deleteAccount(Account account) {
        if (account != null) {
            Integer clientId = account.getClientId();
            clientAccounts.get(clientId).remove(account);
        }
    }
}

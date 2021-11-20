package com.sbrf.reboot.account.repository;

import com.sbrf.reboot.account.entity.Account;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AccountRepositoryImpl implements AccountRepository{
    /**
     * Карта существующих аккаунтов по клиентам
     */
    private HashMap<Long, HashSet<Account>> clientAccounts;
    /**
     * Сиквенс для идентификаторов (так как предполягается удаление, не могу считать размер множества для получения нового Id
     * + подсчет размера может оказать влияние на производительность, если аккаунтов будет много)
     */
    private int sequenceId;

    public AccountRepositoryImpl() {
        clientAccounts = new HashMap<>();
        sequenceId = 0;
    }

    private int nextVal() {
        return ++sequenceId;
    }

    /**
     * Получение всех аккаунтов клиента
     * @param clientId идентификатор клиента
     * @return набор аккаунтов клиента
     */
    public HashSet<Account> getAllAccountsByClientId (Long clientId) {
        return clientAccounts.get(clientId);
    }
    /**
     * Создание аккаунта
     * @param clientId идентификатор клиента, для которого создается параметр
     */
    public Account newAccount(Long clientId) {
        Account account = new Account((String.valueOf(this.nextVal())));
        account.setClientId(clientId);
        if(clientAccounts.containsKey(clientId)) {
            clientAccounts.get(clientId).add(account);
        }
        else {
            HashSet<Account> newClientAccounts = new HashSet<>();
            newClientAccounts.add(account);
            clientAccounts.put(clientId,newClientAccounts);
        }
        return account;
    }
    /**
     * Удаление аккаунта
     * @param account аккаунт для удаления
     */
    public void deleteAccount(Account account) {
        if (account != null) {
            Long clientId = account.getClientId();
            clientAccounts.get(clientId).remove(account);
        }
    }
}

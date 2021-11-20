package com.sbrf.reboot.account.repository;

import com.sbrf.reboot.account.entity.Account;

import java.util.HashMap;
import java.util.HashSet;

public class AccountRepository {
    /**
     * Список существующих аккаунтов
     */
    private HashSet<Account> accounts;

    /**
     * Карта существующих аккаунтов по клиентам
     */
    private HashMap<Long,HashSet> clientAccounts;
    /**
     * Сиквенс для идентификаторов (так как предполягается удаление, не могу считать размер множества для получения нового Id
     * + подсчет размера может оказать влияние на производительность, если аккаунтов будет много)
     */
    private int sequenceId;

    public AccountRepository () {
        accounts = new HashSet<>();
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
        HashSet<Account> foundAccounts = clientAccounts.get(clientId);
        return foundAccounts;
    }
    /**
     * Создание аккаунта
     * @param clientId идентификатор клиента, для которого создается параметр
     */
    public Account newAccount(Long clientId) {
        Account account = new Account((String.valueOf(this.nextVal())));
        account.setClientId(clientId);
        accounts.add(account);
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
        Long clientId = account.getClientId();
        clientAccounts.get(clientId).remove(account);
        accounts.remove(account);
    }
}

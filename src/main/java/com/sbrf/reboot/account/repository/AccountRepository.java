package com.sbrf.reboot.account.repository;

import com.sbrf.reboot.account.entity.Account;

import java.util.HashSet;

public class AccountRepository {
    /**
     * Список существующих аккаунтов
     */
    private HashSet<Account> accounts;
    /**
     * Сиквенс для идентификаторов (так как предполягается удаление, не могу считать размер множества для получения нового Id
     * + подсчет размера может оказать влияние на производительность, если аккаунтов будет много)
     */
    private int sequenceId;

    public AccountRepository () {
        accounts = new HashSet<>();
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
        HashSet<Account> foundAccounts = new HashSet<>();
        for(Account account : accounts) {
            if (account.getClientId().equals(clientId)) {
                foundAccounts.add(account);
            }
        }
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
        return account;
    }
    /**
     * Удаление аккаунта
     * @param account аккаунт для удаления
     */
    public void deleteAccount(Account account) {
        accounts.remove(account);
    }
}

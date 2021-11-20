package com.sbrf.reboot.account.service;

import com.sbrf.reboot.account.entity.Account;
import com.sbrf.reboot.account.repository.AccountRepository;
import com.sbrf.reboot.account.repository.AccountRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepositoryImpl;
    /**
     * Проверка принадлежности аккаунта клиенту
     * @param id Идентификатор клиента
     * @param account аккаунт
     * @return
     */
    public boolean isAccountExist(Integer id, Account account) {
        HashSet<Account> clientAccounts = accountRepositoryImpl.getAllAccountsByClientId(id);
        if(clientAccounts.contains(account))
            return true;
        else
            return false;
    }

    /**
     * Создание аккаунта
     * @param clientId идентификатор клиента
     */
    public Account createAccount(Integer clientId) {

        return accountRepositoryImpl.newAccount(clientId);
    }

    /**
     * Удаление аккаунта
     * @param account аккаунт для удаления
     */
    public void deleteAccount(Account account) {
        accountRepositoryImpl.deleteAccount(account);
    }

    /**
     * Подсчет количества аккаунтов с незаполненными данными по клиенту
     * @return количество аккаунтов с незаполненными данными по клиенту
     */
    public int countEmptyAccounts() {
        int count = accountRepositoryImpl.getAllAccountsByClientId(null).size();
        return count;
    }

}

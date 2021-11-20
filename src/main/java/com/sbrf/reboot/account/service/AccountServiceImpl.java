package com.sbrf.reboot.account.service;

import com.sbrf.reboot.account.entity.Account;
import com.sbrf.reboot.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    /**
     * Проверка принадлежности аккаунта клиенту
     * @param id Идентификатор клиента
     * @param account аккаунт
     * @return
     */
    public boolean isAccountExist(Long id, Account account) {
        HashSet<Account> clientAccounts = accountRepository.getAllAccountsByClientId(id);
        if(clientAccounts.contains(account)) {
            return true;
        }
        else
            return false;
    }

    /**
     * Создание аккаунта
     * @param clientId идентификатор клиента
     */
    public Account createAccount(Long clientId) {
        Account newAccount = accountRepository.newAccount(clientId);
        return newAccount;
    }

    /**
     * Удаление аккаунта
     * @param account аккаунт для удаления
     */
    public void deleteAccount(Account account) {
        accountRepository.deleteAccount(account);
    }

    /**
     * Подсчет количества аккаунтов с незаполненными данными по клиенту
     * @return количество аккаунтов с незаполненными данными по клиенту
     */
    public int countEmptyAccounts() {
        int count = accountRepository.getAllAccountsByClientId(null).size();
        return count;
    }

}

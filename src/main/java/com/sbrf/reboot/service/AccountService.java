package com.sbrf.reboot.service;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(long id, Account account) {
        return accountRepository.getAllAccountsByClientId(id).contains(account);
    }
}
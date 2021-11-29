package com.sbrf.reboot.account.service;


import com.sbrf.reboot.account.entity.Account;

public interface AccountService {

    Account createAccount(Integer clientId);
    void deleteAccount(Account account);
    boolean isAccountExist(Integer id, Account account) ;
    int countEmptyAccounts();
}

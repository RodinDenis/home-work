package com.sbrf.reboot.account.service;


import com.sbrf.reboot.account.entity.Account;

public interface AccountService {

    Account createAccount(Long clientId);
    void deleteAccount(Account account);
    boolean isAccountExist(Long id, Account account) ;
}

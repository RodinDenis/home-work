package com.sbrf.reboot.account.repository;

import com.sbrf.reboot.account.entity.Account;

import java.util.HashMap;
import java.util.HashSet;

public interface AccountRepository {
    HashSet<Account> getAllAccountsByClientId (Integer clientId);
    Account newAccount(Integer clientId);
    void deleteAccount(Account account);
}

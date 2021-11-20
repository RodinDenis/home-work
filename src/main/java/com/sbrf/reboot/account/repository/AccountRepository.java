package com.sbrf.reboot.account.repository;

import com.sbrf.reboot.account.entity.Account;

import java.util.HashMap;
import java.util.HashSet;

public interface AccountRepository {
    HashSet<Account> getAllAccountsByClientId (Long clientId);
    Account newAccount(Long clientId);
    void deleteAccount(Account account);
}

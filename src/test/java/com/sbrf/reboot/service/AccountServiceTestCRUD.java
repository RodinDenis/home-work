package com.sbrf.reboot.service;

import com.sbrf.reboot.account.entity.Account;
import com.sbrf.reboot.account.repository.AccountRepositoryImpl;
import com.sbrf.reboot.account.service.AccountService;
import com.sbrf.reboot.account.service.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AccountServiceTestCRUD {
    AccountRepositoryImpl accountRepositoryImpl;

    AccountService accountService;

    private final static Integer CLIENT_ID = 1;

    @BeforeEach
    void setUp() {
        accountRepositoryImpl = new AccountRepositoryImpl();
        accountService = new AccountServiceImpl(accountRepositoryImpl);
    }

    @Test
    void testCreateAccount () {
        Account account = accountService.createAccount(CLIENT_ID);
        assertTrue(accountService.isAccountExist(CLIENT_ID,account));
    }

    @Test
    void testDeleteAccount () {
        Account account = accountService.createAccount(CLIENT_ID);
        accountService.deleteAccount(account);
        assertFalse(accountService.isAccountExist(CLIENT_ID,account));
    }

}

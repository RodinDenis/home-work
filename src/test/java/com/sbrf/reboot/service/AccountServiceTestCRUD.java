package com.sbrf.reboot.service;

import com.sbrf.reboot.account.entity.Account;
import com.sbrf.reboot.account.repository.AccountRepository;
import com.sbrf.reboot.account.service.AccountService;
import com.sbrf.reboot.account.service.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AccountServiceTestCRUD {
    AccountRepository accountRepository;

    AccountService accountService;

    private final static Long CLIENT_ID = 1L;

    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepository();
        accountService = new AccountServiceImpl(accountRepository);
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

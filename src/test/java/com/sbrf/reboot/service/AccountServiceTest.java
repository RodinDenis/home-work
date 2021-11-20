package com.sbrf.reboot.service;

import com.sbrf.reboot.account.entity.Account;
import com.sbrf.reboot.account.repository.AccountRepository;
import com.sbrf.reboot.account.service.AccountService;
import com.sbrf.reboot.account.service.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    private final static String ACCOUNT_ID = "ACC1234NUM";
    private final static Long CLIENT_ID = 1L;

    Account account;
    HashSet<Account> accounts;

    @BeforeEach
    void setUp() {
        accountService = new AccountServiceImpl(accountRepository);
        account = new Account(ACCOUNT_ID);
        accounts = new HashSet();
        accounts.add(account);
    }

    @Test
    void bookExist() {

        when(accountRepository.getAllAccountsByClientId(CLIENT_ID)).thenReturn(accounts);

        assertTrue(accountService.isAccountExist(CLIENT_ID, account));
    }

    @Test
    void bookNotExist() {

        when(accountRepository.getAllAccountsByClientId(CLIENT_ID)).thenReturn(accounts);

        assertFalse(accountService.isAccountExist(CLIENT_ID, new Account("NEW_RANDOM_ACCOUNT")));
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

    @Test
    void testCountEmptyAccounts() {

        when((accountRepository.getAllAccountsByClientId(null))).thenReturn(accounts);

        assertEquals(accounts.size(),accountService.countEmptyAccounts());
    }
}
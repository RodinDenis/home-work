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

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);

        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    void bookExist() {
        Account account = new Account("ACC1234NUM");
        HashSet<Account> accounts = new HashSet();
        accounts.add(account);

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertTrue(accountService.isAccountExist(1L, account));
    }

    @Test
    void bookNotExist() {
        HashSet<Account> accounts = new HashSet();
        accounts.add(new Account("ACC1234NUM"));

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertFalse(accountService.isAccountExist(1L, new Account("ACC456NUM")));
    }

    @Test
    void testCreateAccount () {
        Account account = accountService.createAccount(123L);
        assertTrue(accountService.isAccountExist(123L,account));
    }

    @Test
    void testDeleteAccount () {
        Account account = accountService.createAccount(123L);
        accountService.deleteAccount(account);
        assertFalse(accountService.isAccountExist(123L,account));
    }

    @Test
    void testCountEmptyAccounts() {
        HashSet<Account> accounts = new HashSet<>();
        accounts.add(new Account(String.valueOf(456)));
        accounts.add(new Account(String.valueOf(789)));

        when((accountRepository.getAllAccountsByClientId(null))).thenReturn(accounts);

        assertEquals(2,accountService.countEmptyAccounts());
    }
}
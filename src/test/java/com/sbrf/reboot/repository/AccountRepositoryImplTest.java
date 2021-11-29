package com.sbrf.reboot.repository;

import com.sbrf.reboot.account.entity.Account;
import com.sbrf.reboot.account.repository.AccountRepository;
import com.sbrf.reboot.account.repository.AccountRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


class AccountRepositoryImplTest {

    AccountRepository accountRepository;


    @Test
    void onlyPersonalAccounts() throws FileNotFoundException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);
        ArrayList<String> strings = new ArrayList<String>() {{
            add("2-ACCNUM");
            add("1-ACCNUM");
            add("4-ACC1NUM");
        }};

        allAccountsByClientId.forEach(e -> assertTrue(strings.contains(e.getId())));
    }

    @Test
    void successGetAllAccountsByClientId() throws FileNotFoundException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);

        assertEquals(1, (int) allAccountsByClientId.stream().filter(e -> e.getId().equals("4-ACC1NUM")).count());
    }

    @Test
    /* Считаю, что метод ничего getAllAccountsByClientId не должен ничего знать о том, как задавался репозиторий:
    * с нуля или из файла, поэтому исключение надо ловить именно на инициализации репозитория.
    * В связи с этим переписала метод*/
    void failGetAllAccountsByClientId() throws FileNotFoundException {
        /*accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class, () -> {
            accountRepository.getAllAccountsByClientId(1);
        });*/
        assertThrows(FileNotFoundException.class, () -> new AccountRepositoryImpl("somePath"));
    }


}
package com.sbrf.reboot.customer.entity;

import com.sbrf.reboot.account.entity.Account;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Customer {
    private int age;
    private String name;
    private Set<Account> accounts = new HashSet<>();

    public void addAccount (Account account) {
        this.accounts.add(account);
    }
}

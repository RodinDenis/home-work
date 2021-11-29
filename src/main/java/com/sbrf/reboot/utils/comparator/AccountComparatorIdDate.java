package com.sbrf.reboot.utils.comparator;

import com.sbrf.reboot.account.entity.Account;

import java.util.Comparator;

public class AccountComparatorIdDate implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        if(o1.getId().equals(o2.getId())) {
            if (o1.getCreateDate().equals(o2.getCreateDate())) {
                return 0;
            }
            else if(o1.getCreateDate().isAfter(o2.getCreateDate())) {
                return 1;
            }
            else return -1;
        }
        else return o1.getId().compareTo(o2.getId());
    }

}

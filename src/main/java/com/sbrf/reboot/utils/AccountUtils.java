package com.sbrf.reboot.utils;

import com.sbrf.reboot.account.entity.Account;
import com.sbrf.reboot.utils.comparator.AccountComparatorIdDate;
import com.sbrf.reboot.utils.comparator.AccountComparatorIdDateBalance;

import java.util.Collections;
import java.util.List;

public class AccountUtils {
    /**
     * Сортировка списка счетов по Id
     * @param accounts списко счетов для сортировки
     * @return список счетов, отсортированный по id
     */
    public static List<Account> sortedById(List<Account> accounts) {
        Collections.sort(accounts);
        return accounts;
    }
    /**
     * Сортировка списка счетов по Id и дате создания
     * @param accounts списко счетов для сортировки
     * @return список счетов, отсортированный по id и дате создания
     */
    public static List<Account> sortedByIdDate (List<Account> accounts) {
        AccountComparatorIdDate comparator = new AccountComparatorIdDate();
        Collections.sort(accounts,comparator);
        return accounts;
    }

    /**
     * Сортировка списка счетов по Id, дате создания, остатку на счете
     * @param accounts списко счетов для сортировки
     * @return отсортированный список счетов
     */
    public static List<Account> sortedByIdDateBalance (List<Account> accounts) {
        AccountComparatorIdDateBalance comparator = new AccountComparatorIdDateBalance();
        Collections.sort(accounts,comparator);
        return accounts;
    }
}

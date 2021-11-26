package com.sbrf.reboot.utils;

import com.sbrf.reboot.account.entity.Account;

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
        return accounts;
    }
}

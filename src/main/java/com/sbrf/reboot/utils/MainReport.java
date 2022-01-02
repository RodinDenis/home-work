package com.sbrf.reboot.utils;

import com.sbrf.reboot.account.entity.Account;
import com.sbrf.reboot.customer.entity.Customer;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class MainReport {
    public static BigDecimal getTotalsWithCompletableFuture (Stream<Account> accounts) {
        return BigDecimal.TEN;
    };

    public static BigDecimal getTotalsWithReact (Stream<Customer> customers) {
        return BigDecimal.TEN;
    }
}

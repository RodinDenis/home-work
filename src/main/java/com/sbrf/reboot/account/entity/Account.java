package com.sbrf.reboot.account.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class Account implements Comparable<Account> {
    /**
     * Идентификатор аккаунта
     */
    private final String id;

    /**
     * Идентификатор клиента
     */
    private final Integer clientId;

    /**
     * Баланс счета
     */
    private BigDecimal balance;

    /**
     * Дата создания счета
     */
    private LocalDate createDate = LocalDate.now() ;

    /**
     * Сравнение по id
     * @param object объкт для сравнения с текущим
     * @return 0 - объекты равны, -1 - текущий объект меньше переданного, 1 - текущий объект больше переданного
     */
    @Override
    public int compareTo(@NonNull Account object) {
        return this.id.compareTo(object.getId());
    }

    private Account (String id, Integer clientId ) {
        this.id = id;
        this.clientId = clientId;
    }

    private Account (String id, Integer clientId , BigDecimal balance, LocalDate date) {
        this.id = id;
        this.clientId = clientId;
        this.balance = balance;
        this.createDate = date;
    }

    public static Account createAccountWithoutInfo (String id, Integer clientId ) {
        return new Account(id,clientId);
    }

    public static Account createAccountWithInfo (String id, Integer clientId,  BigDecimal balance, LocalDate date) {
        return new Account(id,clientId,balance,date);
    }

}

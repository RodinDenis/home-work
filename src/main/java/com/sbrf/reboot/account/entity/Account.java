package com.sbrf.reboot.account.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Account implements Comparable {
    /**
     * Идентификатор аккаунта
     */
    private final String id;

    /**
     * Идентификатор клиента
     */
    private Integer clientId;

    /**
     * Баланс счета
     */
    private BigDecimal balance;

    /**
     * Дата создания счета
     */
    private LocalDate createDate;

    public Account (String id) {
        this.id = id;
        this.clientId = null;
        this.balance = null;
        this.createDate = LocalDate.now();
    }

    public Account (String id, Integer client) {
        this.id = id;
        this.clientId = client;
        this.balance = null;
        this.createDate = LocalDate.now();
    }

    public Account (String id, Integer client,BigDecimal balance) {
        this.id = id;
        this.clientId = client;
        this.balance = balance;
        this.createDate = LocalDate.now();
    }

    /**
     * Сравнение по id
     * @param o объкт для сравнения с текущим
     * @return 0 - объекты равны, -1 - текущий объект меньше переданного, 1 - текущий объект больше переданного
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Account) {
            Account object = (Account) o;
            if (this.id.equals(object.getId()) || this == object ) {
                return 0;
            }
            else
                return this.id.compareTo(object.getId());
        }
        else
            throw new UnsupportedOperationException();
    }
}

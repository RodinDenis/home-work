package com.sbrf.reboot.account.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
public class Account {
    /**
     * Идентификатор аккаунта
     */
    private final String id;

    /**
     * Идентификатор клиента
     */
    private Long clientId;

}

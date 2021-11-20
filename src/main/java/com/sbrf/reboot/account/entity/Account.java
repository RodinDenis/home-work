package com.sbrf.reboot.account.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Account {
    /**
     * Идентификатор аккаунта
     */
    private final String id;

    /**
     * Идентификатор клиента
     */
    private Integer clientId;

    public Account (String id, Integer client) {
        this.id = id;
        this.clientId = client;
    }
}

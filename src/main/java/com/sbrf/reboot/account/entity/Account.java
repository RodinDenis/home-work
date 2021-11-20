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
    private Long clientId;

    public Account (String id, Long client) {
        this.id = id;
        this.clientId = client;
    }
}

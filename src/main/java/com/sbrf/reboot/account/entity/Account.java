package com.sbrf.reboot.account.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
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
}

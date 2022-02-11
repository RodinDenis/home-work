package com.sbrf.reboot.dto;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String eMail;

    public Customer() {
    }

    public Customer(Long id, String name, String eMail) {
        this.id = id;
        this.name = name;
        this.eMail = eMail;
    }
}

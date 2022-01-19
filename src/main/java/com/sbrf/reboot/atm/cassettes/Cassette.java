package com.sbrf.reboot.atm.cassettes;

import java.util.ArrayList;

public class Cassette<T> {

    ArrayList<T> banknotes;



    public Cassette(ArrayList<T> banknotes) {
        this.banknotes = banknotes;
    }

    // в будущем можно добавить обработчик изменения размера ArrayList
    // и сохранять новый размер в отдельную переменную, чтобы не приходилось
    // каждый раз вызывать size()
    public int getCountBanknotes() {
        return banknotes.size();
    }
}

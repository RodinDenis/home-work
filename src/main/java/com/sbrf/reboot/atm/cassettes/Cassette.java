package com.sbrf.reboot.atm.cassettes;

import java.util.ArrayList;
import java.util.List;

public class Cassette <T>{

    private List<T> storage;

    public Cassette(ArrayList<T> storage) {
        this.storage = storage;
    }

    public int getCountBanknotes(){
        return storage.size();
    }
}

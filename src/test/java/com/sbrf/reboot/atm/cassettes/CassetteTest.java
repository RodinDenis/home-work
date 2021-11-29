package com.sbrf.reboot.atm.cassettes;

import atm.Banknote;
import atm.BanknoteValue;
import atm.Cassette;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CassetteTest {

    class OneHundred extends Banknote {
        OneHundred() {
            super(BanknoteValue.valueOf(100));
        }
    }

    class OneThousand extends Banknote {
        OneThousand() {
            super(BanknoteValue.valueOf(1000));
        }
    }

    @Test
    void getCountBanknotes() {
        OneHundred oneHundred = new OneHundred();

        Cassette<OneHundred> cassette = new Cassette<>(new ArrayList<OneHundred>() {{
            add(oneHundred);
//            add(new OneThousand()); //it will not compile
//            add(new Banknote()); //it will not compile
        }});

        Assertions.assertEquals(1, cassette.getCountBanknotes());
    }
}
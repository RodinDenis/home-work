package com.sbrf.reboot.atm.cassettes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CassetteTest {

    class OneHundred extends Banknote {
        public OneHundred() {
            this.setValue(100);
        }
    }

    class OneThousand extends Banknote {
        public OneThousand() {
            this.setValue(1000);
        }
    }

    @Test
    void getCountBanknotes() {
        OneHundred oneHundred = new OneHundred();
        ArrayList<OneHundred> a = new ArrayList<>();
        Cassette<OneHundred> cassette = new Cassette<>(
                new ArrayList<OneHundred>() {{
                        add(oneHundred);
/*            add(new OneThousand()); //it will not compile
            add(new Banknote()); //it will not compile*/
                    }}
        );

        Assertions.assertEquals(1, cassette.getCountBanknotes());
    }
}
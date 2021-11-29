package atm;

/**
 * Допустимые номиналы банкнот
 */
public enum BanknoteValue {ONE_HUNDRED, ONE_THOUSAND, FIVE_HUNDREDS,FIVE_THOUSANDS;

public static BanknoteValue valueOf(int value) {
    switch(value) {
        case 100 : {return ONE_HUNDRED; }
        case 1000 : {return ONE_THOUSAND; }
        case 500 : {return FIVE_HUNDREDS; }
        case 5000 : {return FIVE_THOUSANDS; }
        default: return null;
    }
}
}

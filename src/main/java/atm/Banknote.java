package atm;

/**
 * Банкнота
 */
public class Banknote {
    /**
     * Номинал банкноты
     */
    private final BanknoteValue value;

    public Banknote(BanknoteValue value) {
        this.value = value;
    }
}

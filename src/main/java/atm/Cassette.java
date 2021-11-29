package atm;

import java.util.ArrayList;

/**
 * Кассета для банкнот
 * @param <T>
 */
public class Cassette<T> {
    /**
     * Набор банкнот в кассете
     */
    private ArrayList<T> banknotes;

    public Cassette(ArrayList<T> banknotes) {
        this.banknotes = banknotes;
    }

    /**
     * Количество банкнот в кассете
     * @return
     */
    public int getCountBanknotes() {
        return banknotes.size();
    }
}

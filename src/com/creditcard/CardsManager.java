package com.creditcard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class class provides the business logic which can be done on the credit
 * cards.
 *
 * @author Ricardo Santos
 */
public class CardsManager {

    private List<CreditCard> cards = new ArrayList<>();

    /**
     * Sorts the list cod card based on the compaction criterion received as a
     * parameter.
     *
     * @param comparator - compaction criterion
     */
    void sortCard(Comparator<CreditCard> comparator) {
        cards.sort(comparator);
    }

    void output() {
        for (CreditCard c : cards) {
            System.out.println(c);
        }
    }

    public List<CreditCard> getCards() {
        return cards;
    }

    public void setCards(List<CreditCard> cards) {
        this.cards = cards;
    }

}

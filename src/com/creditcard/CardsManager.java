package com.creditcard;

import java.util.ArrayList;
import java.util.List;
 
/**
 * This class class provides the business logic which can be done on the credit
 * cards.
 *
 * @author Ricardo Santos
 */
public class CardsManager {

    private List<CreditCard> cards = new ArrayList<>();

    CardsManager(List<CreditCard> cards) {
        this.cards = cards;
    }

    /** Sorts the list of card. */
    void sortCard() {
        cards.sort((CreditCard c1, CreditCard c2) -> (-c1.getExpiryDate().compareTo(c2.getExpiryDate())));
    }

    void output() {
        cards.stream().forEach(System.out::println);
    }

    public List<CreditCard> getCards() {
        return cards;
    }
}

package com.creditcard;

import java.util.Comparator;

/**
 * @deprecated 
 * Comparator used to order card based on a descendent expiry date. If the date
 * is the same, the cards are ordered based on the card number.
 */
public class DecrescenteExpiryDateComparator implements Comparator<CreditCard>{

    @Override
    public int compare(CreditCard card1, CreditCard card2) {
        
        int result = 0;
        if (card1.getExpiryDate().isBefore(card2.getExpiryDate())) {
            result = 1;
        } else if (card1.getExpiryDate().isAfter(card2.getExpiryDate())) {
            result = -1;
        }
        if (result != 0) {
            return result;
        }

        // to be consistent with equals()
        return card1.getCardNumber().compareTo(card2.getCardNumber());
    }

}

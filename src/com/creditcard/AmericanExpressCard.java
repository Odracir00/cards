package com.creditcard;

import java.time.YearMonth;

/**
 * Implements the type of card American Express.
 * @author Ricardo Santos 
 */
public class AmericanExpressCard extends CreditCard {
    
    final static String BANK = "American Express";
    final static String CARD_PATTERN = "\\b[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{3}\\b";

    private final static String MASKED_CARD_PATTERN = "xxxx-xxxx-xxxx-";

    AmericanExpressCard(String cardNumber, YearMonth expiryDate) {
        super(cardNumber, expiryDate);
        bank = BANK;
        generateMaskedNumber();
    }

    @Override
    final void generateMaskedNumber() {
        maskedCardNumber = MASKED_CARD_PATTERN + cardNumber.substring(15);
    }
    
}

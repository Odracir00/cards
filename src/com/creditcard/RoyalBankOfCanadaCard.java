package com.creditcard;

import java.time.YearMonth;

public class RoyalBankOfCanadaCard extends CreditCard {
    
final static String BANK = "Royal Bank of Canada";
    final static String CARD_PATTERN = "\\b[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}\\b";
    private final static String MASKED_CARD_PATTERN = "-xxxx-xxxx-xxxx";

    RoyalBankOfCanadaCard(String cardNumber, YearMonth expiryDate) {
        super(cardNumber, expiryDate);
        bank = BANK;
        generateMaskedNumber();
    }

    @Override
    final protected void generateMaskedNumber() {
        maskedCardNumber = cardNumber.substring(0, 4) + MASKED_CARD_PATTERN;
    }
    
}

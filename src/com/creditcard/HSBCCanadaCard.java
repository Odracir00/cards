/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcard;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Ricardo Santos
 */
public class HSBCCanadaCard extends CreditCard {

    final static String BANK = "HSBC Canada";
    final static String CARD_PATTERN = "\\b[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}\\b";
    private final static String MASKED_CARD_PATTERN = "xx-xxxx-xxxx-xxxx";

    HSBCCanadaCard(String cardNumber, YearMonth expiryDate) {
        super(cardNumber, expiryDate);
        bank = BANK;
        generateMaskedNumber();
    }

    @Override
    final protected void generateMaskedNumber() {
        maskedCardNumber = cardNumber.substring(0, 2) + MASKED_CARD_PATTERN;
    }

}

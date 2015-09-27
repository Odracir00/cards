package com.creditcard;

import java.text.ParseException;

/**
 * This class is responsible for validating credit card's data (Strings).
 * @author Ricardo Santos
 */
public class CardValidator {

    /**
     * Validates that the received String are valid to create a credit card
     * object
     * @param creditCardData strings containing the name of the bank, card
     *                       number and expiry date.
     * @throws ParseException if the data is invalid
     */
    public static void validateCrediteCard(String[] creditCardData) throws ParseException {

        if (creditCardData.length != 3) { // this 3 elements cannot be null
            throw new ParseException(" - Invalid card Data name", 0);
        }
        validateBankName(creditCardData[0]);

        switch (creditCardData[0]) {
            case HSBCCanadaCard.BANK:
                validateCardNumber(creditCardData[1], HSBCCanadaCard.CARD_PATTERN);
                break;
            case RoyalBankOfCanadaCard.BANK:
                validateCardNumber(creditCardData[1], RoyalBankOfCanadaCard.CARD_PATTERN);
                break;
            case AmericanExpressCard.BANK:
                validateCardNumber(creditCardData[1], AmericanExpressCard.CARD_PATTERN);
        }

        validateExpiryDate(creditCardData[2]);
    }

    /**
     * Ensures that the card belongs to a supported bank.
     * @param bankName card's bank name.
     * @throws ParseException If the bank is unknown.
     */
    static void validateBankName(String bankName) throws ParseException {
        if (!(bankName.equals(HSBCCanadaCard.BANK) || bankName.equals(RoyalBankOfCanadaCard.BANK) || 
                bankName.equals(AmericanExpressCard.BANK))) {
            throw new ParseException(bankName + " - Invalid bank name", 0);
        }
    }

    static void validateCardNumber(String cardNumber, String matchingPattern) throws ParseException {
        if (!cardNumber.matches(matchingPattern)) {
            throw new ParseException(cardNumber + " - Invalid Card", 0);
        }
    }

    static void validateExpiryDate(String expDate) throws ParseException {
        String[] elements = expDate.split("-");
        if (elements.length != 2) {
            throw new ParseException(expDate + " - Invalid Expiry Date", 0);
        }
        validateYear(elements[1]);
        validateMonth(elements[0]);
    }

    static void validateYear(String year) throws ParseException {
        int y = 0;
        try {
            y = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            throw new ParseException(y + " - Invalid Year", 0);
        }

        if (y < 2000 || y >= 2050) {
            throw new ParseException(y + " - Invalid Year", 0);
        }
    }

    static void validateMonth(String month) throws ParseException {
        String m = month;

        if (m.equals("Jan") || m.equals("Feb") || m.equals("Mar") || m.equals("Apr")
                || m.equals("May") || m.equals("Jun") || m.equals("Jul") || m.equals("Aug")
                || m.equals("Sep") || m.equals("Oct") || m.equals("Nov") || m.equals("Dec")) {
            //ok
        } else {
            throw new ParseException(m + " - Invalid Month", 0);
        }
    }
}

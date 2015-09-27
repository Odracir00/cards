package com.creditcard;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class CreditCard {

    String bank;
    String cardNumber;
    String maskedCardNumber;
    YearMonth expiryDate;

    /** Defines the way that the card should be masked.    */
    abstract void generateMaskedNumber();

    CreditCard(String cardNumber, YearMonth expDate) {
        this.cardNumber = cardNumber;
        expiryDate = expDate;
    }
    
    /**
     * @return the bank
     */
    public String getBank() {
        return bank;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @return the maskedCardNumber
     */
    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    /**
     * @return the yearMonth
     */
    public YearMonth getExpiryDate() {
        return expiryDate;
    }
    
    /**
     * Overriding equals to be consistent with Comparator.compare Only the card
     * number and the expiry date a taken into account to define equality.
     * @param o object to compare to
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CreditCard)) {
            return false;
        }
        CreditCard c = (CreditCard) o;
        // Only the expiryDate and card number are used to define equality.
        return expiryDate.equals(c.expiryDate) && cardNumber.equals(c.cardNumber);
    }

    @Override
    public int hashCode() {
        return 31 * expiryDate.hashCode() + cardNumber.hashCode();
    }

    @Override
    public String toString() {
        return bank + "," + maskedCardNumber + ","
                + expiryDate.format(DateTimeFormatter.ofPattern("MMM-yyyy", Locale.UK));
    }

    String toStringWithFullCardNumber() {   
        return bank + "," + cardNumber + ","
                + expiryDate.format(DateTimeFormatter.ofPattern("MMM-yyyy", Locale.UK));
    }

}

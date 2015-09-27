/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcard;

import java.text.ParseException;
import org.junit.Test;

/**
 *
 * @author Ricardo Santos
 */
public class CardValidatorTest {

    private final static String BANK1 = "HSBC Canada";
    private final static String BANK2 = "Royal Bank of Canada";
    private final static String BANK3 = "American Express";
    private final static String INVALID_BANK1 = "Lloyds Bank";
    
    private final static String CARD_NUMBER16_VALIDE = "5601-2345-3446-5678";
    private final static String CARD_NUMBER16_INVALIDE1 = "5601-2345-3446 5678";
    private final static String CARD_NUMBER16_INVALIDE2 = "5601234534465678";
    private final static String CARD_NUMBER16_INVALIDE3 = "A601-2345-3446-5678";
    private final static String CARD_NUMBER16_INVALIDE4 = "A5601-2345-3446-5678";
    
    private final static String CARD_NUMBER15_VALIDE = "3786-7334-8965-345";
    private final static String CARD_NUMBER15_INVALIDE1 = "3786-7334-8965 345";
    private final static String CARD_NUMBER15_INVALIDE2 = "378673348965345";
    private final static String CARD_NUMBER15_INVALIDE3 = "3786-7334-8965-34A";
    private final static String CARD_NUMBER15_INVALIDE4 = "3786-7334-8965-345B";
     
    
    ///// Testing validateCrediteCard
    
    @Test
    public void testValidateCrediteCard() throws ParseException {
        String[] cardData = {"HSBC Canada", "5601-2345-3446-5678", "Dec-2016"};
        CardValidator.validateCrediteCard(cardData); // no exception is thrown
    }

    
    ///// Testing validateBankName
        
    @Test
    public void testValidateBankName_valid() throws ParseException {
        CardValidator.validateBankName(BANK1);
        CardValidator.validateBankName(BANK2);
        CardValidator.validateBankName(BANK3);
    }

    @Test(expected = ParseException.class)
    public void testValidateBankName_invalid() throws ParseException {
        CardValidator.validateBankName(INVALID_BANK1);
    }

    
    ///// Testing validateCardNumber
    
    @Test
    public void testValidateCardNumber16Digits_valid() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER16_VALIDE, HSBCCanadaCard.CARD_PATTERN);
    }

    @Test(expected = ParseException.class)
    public void testValidateCardNumber16Digits_invalid() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER16_INVALIDE1, HSBCCanadaCard.CARD_PATTERN);
    }

    @Test(expected = ParseException.class)
    public void testValidateCardNumber16Digits_invalid2() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER16_INVALIDE2, HSBCCanadaCard.CARD_PATTERN);
    }

    @Test(expected = ParseException.class)
    public void testValidateCardNumber16Digits_invalid3() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER16_INVALIDE3, HSBCCanadaCard.CARD_PATTERN);
    }
  
    @Test(expected = ParseException.class)
    public void testValidateCardNumber16Digits_invalid4() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER16_INVALIDE4, HSBCCanadaCard.CARD_PATTERN);
    }

    @Test
    public void testValidateCardNumber15Digits_valid() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER15_VALIDE, AmericanExpressCard.CARD_PATTERN);
    }

    @Test(expected = ParseException.class)
    public void testValidateCardNumber15Digits_invalid() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER15_INVALIDE1, AmericanExpressCard.CARD_PATTERN);
    }

    @Test(expected = ParseException.class)
    public void testValidateCardNumber15Digits_invalid2() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER15_INVALIDE2, AmericanExpressCard.CARD_PATTERN);
    }

    @Test(expected = ParseException.class)
    public void testValidateCardNumber15Digits_invalid3() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER15_INVALIDE3, AmericanExpressCard.CARD_PATTERN);
    }

    @Test(expected = ParseException.class)
    public void testValidateCardNumber15Digits_invalid4() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER15_INVALIDE4, AmericanExpressCard.CARD_PATTERN);
    }

    @Test(expected = ParseException.class)
    public void testValidateCardNumberBankMismatch1() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER16_VALIDE, AmericanExpressCard.CARD_PATTERN);
    }
    
    @Test(expected = ParseException.class)
    public void testValidateCardNumberBankMismatch2() throws ParseException {
        CardValidator.validateCardNumber(CARD_NUMBER15_VALIDE, HSBCCanadaCard.CARD_PATTERN);
    }

    
    ///// Testing validateExpiryDate
    
    @Test
    public void testValidateExpireDate_valid() throws ParseException {
        CardValidator.validateExpiryDate("Jan-2000");
        CardValidator.validateExpiryDate("Dec-2015");
        CardValidator.validateExpiryDate("Nov-2017");
        CardValidator.validateExpiryDate("Oct-2017");
        CardValidator.validateExpiryDate("Dec-2018");
    }

    @Test(expected = ParseException.class)
    public void testValidateExpireDate_invalid1() throws ParseException {
        CardValidator.validateExpiryDate("Dec 2015");
    }

    @Test(expected = ParseException.class)
    public void testValidateExpireDate_invalid2() throws ParseException {
        CardValidator.validateExpiryDate("Dec2015");
    }

    @Test(expected = ParseException.class)
    public void testValidateExpireDate_invalid3() throws ParseException {
        CardValidator.validateExpiryDate("122015");
    }

    
    ///// Testing validateYear
    
    @Test
    public void testValidateYear_valid1() throws ParseException {
        CardValidator.validateYear("2000");
        CardValidator.validateYear("2015");
        CardValidator.validateYear("2049");
    }

    @Test(expected = ParseException.class)
    public void testValidateYear_invalid1() throws ParseException {
        CardValidator.validateYear("1999");
    }

    @Test(expected = ParseException.class)
    public void testValidateYear_invalid2() throws ParseException {
        CardValidator.validateYear("2051");
    }

    @Test(expected = ParseException.class)
    public void testValidateYear_invalid3() throws ParseException {
        CardValidator.validateYear("Something else");
    }

    
    ///// Testing validateMonth
    
    @Test
    public void testValidateMonth_valid() throws ParseException {
        CardValidator.validateMonth("Jan");
        CardValidator.validateMonth("Feb");
        CardValidator.validateMonth("Mar");
        CardValidator.validateMonth("Apr");
        CardValidator.validateMonth("May");
        CardValidator.validateMonth("Jun");
        CardValidator.validateMonth("Jul");
        CardValidator.validateMonth("Aug");
        CardValidator.validateMonth("Sep");
        CardValidator.validateMonth("Oct");
        CardValidator.validateMonth("Nov");
        CardValidator.validateMonth("Dec");
    }

    @Test(expected = ParseException.class)
    public void testValidateMonth_invalid1() throws ParseException {
        CardValidator.validateMonth("December");
    }

    @Test(expected = ParseException.class)
    public void testValidateMonth_invalid2() throws ParseException {
        CardValidator.validateMonth("Something else");
    }

}

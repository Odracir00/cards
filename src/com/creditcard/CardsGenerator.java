package com.creditcard;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is reprocessable for generation random credit cards, which can be
 * used to better test the application.
 *
 * @author Ricardo Santos
 */
public class CardsGenerator {
    
    final private static Random rGenerator = new Random();
    /** Array with the supported banks. */
    final private static String[] banks = {HSBCCanadaCard.BANK,
        RoyalBankOfCanadaCard.BANK, AmericanExpressCard.BANK};

    /**
     * Generates card with random data.
     * @param numberOfCards Number of card to be generated.
     * @return list with the generated.
     */
    static List<CreditCard> generateCreditCards(int numberOfCards) {
        List<CreditCard> cards = new ArrayList<>(numberOfCards);
        for (int i = 0; i < numberOfCards; i++) {
            cards.add(i, generateCard());
        }
        return cards;
    }
    
    /**
     * Generates a card with random valid data.
     * @return the new card.
     */
    static CreditCard generateCard() {

        CreditCard card = null;
        String bank = generateRandomBank();
        String cardNum = generateRandomCardNumber();
        YearMonth expiryDate = generateExpiryDate();

        switch (bank) {
            case HSBCCanadaCard.BANK:                   // 16 digits
                card = new HSBCCanadaCard(cardNum, expiryDate);
                break;
            case RoyalBankOfCanadaCard.BANK:           // 16 digits
                card = new RoyalBankOfCanadaCard(cardNum, expiryDate);
                break;
            case AmericanExpressCard.BANK:             // 15 digits
                cardNum = removeLastChar(cardNum);
                card = new AmericanExpressCard(cardNum, expiryDate);
                break;
            default:
                throw new IllegalStateException(bank + " - Invalid bank name");
        }

        return card;
    }

    static String generateRandomBank() {
        return banks[rGenerator.nextInt(3)];
    }

    static String generateRandomCardNumber() {

        String cardNum = "";
        for (int i = 1; i <= 4; i++) {
            cardNum += rGenerator.nextInt(10) + "" + rGenerator.nextInt(10)
                     + "" + rGenerator.nextInt(10) + "" + rGenerator.nextInt(10);
            if (i < 4) {
                cardNum += "-";
            }
        }
        return cardNum;
    }

    private static String removeLastChar(String s) {
        String newStr = s.substring(0, s.length() - 1);
        return newStr;
    }

    static YearMonth generateExpiryDate() {
        YearMonth ym = YearMonth.of(generateRandomYear(), generateRandomMonth());
        return ym;
    }

    static int generateRandomYear() {
        int randomNum = 2000 + rGenerator.nextInt(50);
        return randomNum;
    }

    static int generateRandomMonth() {
        int randomNum = 1 + rGenerator.nextInt(12);
        return randomNum;
    }
}

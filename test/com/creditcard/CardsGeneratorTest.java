package com.creditcard;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardsGeneratorTest {

    private final static int NUM_CARDS = 1000;

    public CardsGeneratorTest() {
    }

    @Test
    public void testGenerateCreditCards() {
        List<CreditCard> cards = CardsGenerator.generateCreditCards(NUM_CARDS);
        assertEquals(NUM_CARDS, cards.size());
    }

    @Test
    public void testGenerateCard() {
        CreditCard cd = CardsGenerator.generateCard();
        switch (cd.getBank()) {
            case HSBCCanadaCard.BANK:
                assertTrue(cd.getCardNumber().matches(HSBCCanadaCard.CARD_PATTERN));
                assertEquals(cd.getCardNumber().length(), cd.getMaskedCardNumber().length());
            case RoyalBankOfCanadaCard.BANK:
                assertTrue(cd.getCardNumber().matches(RoyalBankOfCanadaCard.CARD_PATTERN));
                assertEquals(cd.getCardNumber().length(), cd.getMaskedCardNumber().length());
                break;
            case AmericanExpressCard.BANK:
                assertTrue(cd.getCardNumber().matches(AmericanExpressCard.CARD_PATTERN));
                assertEquals(cd.getCardNumber().length(), cd.getMaskedCardNumber().length());
        }
        assertNotNull(cd.getExpiryDate());
    }

    @Test
    public void testGenerateRandomBank() {
        String b = CardsGenerator.generateRandomBank();
        assertTrue(b.equals(HSBCCanadaCard.BANK) || b.equals(RoyalBankOfCanadaCard.BANK)
                || b.equals(AmericanExpressCard.BANK));
    }

    @Test
    public void testGenerateRandomCardNumber() {
        String cn = CardsGenerator.generateRandomCardNumber();
         assertTrue(cn.matches(HSBCCanadaCard.CARD_PATTERN));  
    } 

    @Test
    public void testGenerateExpiryDate() {
        assertNotNull(CardsGenerator.generateExpiryDate());
    }

    @Test
    public void testGenerateRandomYear() {
        int y = CardsGenerator.generateRandomYear();
        assertTrue(y >= 2000);
        assertTrue(y < 2050);
    }

    @Test
    public void testGenerateRandomMonth() {
        int m = CardsGenerator.generateRandomMonth();
        assertTrue(m >= 1 && m <= 12);
    }

}

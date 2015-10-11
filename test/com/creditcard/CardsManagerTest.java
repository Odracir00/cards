package com.creditcard;

import java.time.YearMonth;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Santos
 */
public class CardsManagerTest {
    
    private final static String CARD_NUMBER1 = "4519-4532-4524-0001";
    
    CardsManager manager;
 
    /**
     * Test of sortCard method, of class CardsManager.
     */
    @Test
    public void testSortCard() {

        List<CreditCard> cards = new LinkedList<>();
        cards.add(createCard(2015, 5));
        cards.add(createCard(2000, 1));
        cards.add(createCard(2017, 11));
        cards.add(createCard(2017, 10));
        
        manager = new CardsManager(cards);
        manager.sortCard();

        List<CreditCard> sortedCards = manager.getCards();
        assertEquals(4, sortedCards.size());

        CreditCard card = sortedCards.get(0);
        assertEquals(2017, card.getExpiryDate().getYear());
        assertEquals(11, card.getExpiryDate().getMonthValue());
                
        card = sortedCards.get(1);
        assertEquals(2017, card.getExpiryDate().getYear());
        assertEquals(10, card.getExpiryDate().getMonthValue());
        
        card = sortedCards.get(2);
        assertEquals(2015, card.getExpiryDate().getYear());
        assertEquals(5, card.getExpiryDate().getMonthValue());
        
        card = sortedCards.get(3);
        assertEquals(2000, card.getExpiryDate().getYear());
        assertEquals(1, card.getExpiryDate().getMonthValue());
        
    }

    private CreditCard createCard(int year, int month) {
        return new HSBCCanadaCard(CARD_NUMBER1, YearMonth.of(year, month));
    }

}

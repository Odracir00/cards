package com.creditcard;

import java.time.YearMonth;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreditCardTest {
    
    private final static String CARD_NUMBER1 = "3786-7334-8965-0001";
    private final static String CARD_NUMBER2 = "3786-7334-8965-0001";
    private final static YearMonth YEAR_MONTH = YearMonth.of(2016, 1);

    @Test
    public void testEquals_true() {
        CreditCard c1 = new HSBCCanadaCard(CARD_NUMBER1, YEAR_MONTH);
        CreditCard c2 = new RoyalBankOfCanadaCard(CARD_NUMBER1, YEAR_MONTH);
        
        // only the card number and the expiry date are taken into account to define equality.
        assertTrue(c1.equals(c2));
    }

       public void testEquals_false() {
        CreditCard c1 = new HSBCCanadaCard(CARD_NUMBER1, YEAR_MONTH);
        CreditCard c2 = new RoyalBankOfCanadaCard(CARD_NUMBER2, YEAR_MONTH);
        
        assertFalse(c1.equals(c2));
    } 
}

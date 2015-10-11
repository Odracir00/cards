package com.creditcard;

import java.time.YearMonth;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreditCardTest {
    
    private final static String CARD_NUMBER1 = "3786-7334-8965-0001";
    private final static YearMonth YEAR_MONTH_1 = YearMonth.of(2016, 1);
    private final static YearMonth YEAR_MONTH_2 = YearMonth.of(2016, 2);

    @Test
    public void testEquals_true() {
        CreditCard c1 = new HSBCCanadaCard(CARD_NUMBER1, YEAR_MONTH_1);
        CreditCard c2 = new RoyalBankOfCanadaCard(CARD_NUMBER1, YEAR_MONTH_1);

        // only the expiry date are taken into account to define equality.
        assertTrue(c1.equals(c2));
    }

    @Test
    public void testEquals_false() {
        CreditCard c1 = new HSBCCanadaCard(CARD_NUMBER1, YEAR_MONTH_1);
        CreditCard c2 = new RoyalBankOfCanadaCard(CARD_NUMBER1, YEAR_MONTH_2);

        assertFalse(c1.equals(c2));
    }
}

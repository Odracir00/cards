package com.creditcard;

import java.time.YearMonth;
import org.junit.Test;
import static org.junit.Assert.*;

public class AmericanExpressCardTest {

    private final static String CARD_NUMBER = "3786-7334-8965-345";
    private final static String MASKED_CARD_NUMBER = "xxxx-xxxx-xxxx-345";
    private final static YearMonth YEAR_MONTH = YearMonth.of(2016, 12);

    @Test
    public void testGenerateMaskedNumber() {
        AmericanExpressCard card = new AmericanExpressCard(CARD_NUMBER, YEAR_MONTH);
        card.generateMaskedNumber();
        assertEquals(MASKED_CARD_NUMBER, card.getMaskedCardNumber());
    }

}

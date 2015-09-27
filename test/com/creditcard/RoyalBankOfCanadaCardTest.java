package com.creditcard;

import java.time.YearMonth;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Santos
 */
public class RoyalBankOfCanadaCardTest {

    private final static String CARD_NUMBER = "4519-4532-4524-2456";
    private final static String MASKED_CARD_NUMBER = "4519-xxxx-xxxx-xxxx";
    private final static YearMonth YEAR_MONTH = YearMonth.of(2016, 12);

    @Test
    public void testGenerateMaskedNumber() {
        RoyalBankOfCanadaCard card = new RoyalBankOfCanadaCard(CARD_NUMBER, YEAR_MONTH);
        card.generateMaskedNumber();
        assertEquals(MASKED_CARD_NUMBER, card.getMaskedCardNumber());
    }

}

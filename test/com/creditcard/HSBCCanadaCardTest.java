package com.creditcard;

import java.time.YearMonth;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Santos
 */
public class HSBCCanadaCardTest {

    private final static String CARD_NUMBER = "5601-2345-3446-5678";
    private final static String MASKED_CARD_NUMBER = "56xx-xxxx-xxxx-xxxx";
    private final static YearMonth YEAR_MONTH = YearMonth.of(2016, 12);

    @Test
    public void testGenerateMaskedNumber() {
        HSBCCanadaCard card = new HSBCCanadaCard(CARD_NUMBER, YEAR_MONTH);
        card.generateMaskedNumber();
        assertEquals(MASKED_CARD_NUMBER, card.getMaskedCardNumber());
    }

}

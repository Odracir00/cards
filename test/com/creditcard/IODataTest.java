/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Santos
 */
public class IODataTest {

    private final static String CARD_NUMBER1 = "3786-7334-8965-0001";
    private final static YearMonth YEAR_MONTH = YearMonth.of(2016, 1);
    private final static String YEAR_MONTH_STRING = "Dec-2015";


    public IODataTest() {
    }

    /**
     * Test of readCardsFromFile method, of class IOData.
     */
    @Test
    public void testReadCardsFromFile() throws FileNotFoundException, ParseException {

        String file = "mid-test.csv";
        List<CreditCard> cards = IOData.readCardsFromFile(file);
        assertEquals(3, cards.size());
        CreditCard card = cards.get(0);
        assertEquals("HSBC Canada", card.getBank());
        assertEquals("5601-2345-3446-5678", card.getCardNumber());
        assertEquals("Nov-2017", card.getExpiryDate().format(DateTimeFormatter.ofPattern("MMM-yyyy", Locale.UK)));
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadCardsFromFile_WrongFileName() throws Exception {
        String file = "mid-test2.csv";
        IOData.readCardsFromFile(file);
    }

    @Test(expected = ParseException.class)
    public void testReadCardsFromFile_WrongFormatFile() throws Exception {
        String file = "mid-test_wrongformat.csv";
        IOData.readCardsFromFile(file);
    }

    @Test
    public void testCreateCard() throws Exception {
        CreditCard c = IOData.createCard(HSBCCanadaCard.BANK, CARD_NUMBER1, YEAR_MONTH_STRING);
        assertTrue(c instanceof HSBCCanadaCard);

        c = IOData.createCard(RoyalBankOfCanadaCard.BANK, CARD_NUMBER1, YEAR_MONTH_STRING);
        assertTrue(c instanceof RoyalBankOfCanadaCard);

        c = IOData.createCard(AmericanExpressCard.BANK, CARD_NUMBER1, YEAR_MONTH_STRING);
        assertTrue(c instanceof AmericanExpressCard);
    }


    
    /**
     * Test of readCardsFromFile method, of class IOData.
     */
    @Test
    public void testWriteCardsToFile() throws IOException {
        
        List<CreditCard> cards = new LinkedList<>();
        cards.add(new HSBCCanadaCard(CARD_NUMBER1, YEAR_MONTH));
        cards.add(new RoyalBankOfCanadaCard(CARD_NUMBER1, YEAR_MONTH));
        
        String file = "test-file.csv";
        IOData.writeCardsToFile(file, cards);
        File f = new File(file); 

        assertTrue(f.exists());
        assertFalse(f.isDirectory());
        
        f.delete(); // clean up testing data. 
    }
    
}

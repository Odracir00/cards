package com.creditcard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class IOData {

    private IOData() {
    }

    /**
     * Reads a file containing credit cards information.
     *
     * @param fileName file to be read.
     * @return A list containing all credit cards read.
     * @throws FileNotFoundException if it was not possible to open the file
     * @throws ParseException        If the file in not well formatted.
     */
    static List<CreditCard> readCardsFromFile(String fileName) throws IOException, FileNotFoundException, ParseException {

        List<CreditCard> cards = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            
            String line;
            while ((line = processReadCards(br, (x) -> x.readLine())) != null && line.length() != 0) {
                line = line.replaceAll("  ", " ").trim();

                String[] elements = line.split(",");
                if (elements.length != 3) {
                    throw new ParseException("Incorrect file data.", 0);
                }

                CardValidator.validateCrediteCard(elements);
                CreditCard card = createCard(elements[0], elements[1], elements[2]);
                cards.add(card);
            }
        }

        return cards;
    }
  
    private static String processReadCards(BufferedReader br, BufferedReaderProcessor p) throws IOException {
        return p.process(br);
    }

    private interface BufferedReaderProcessor {
        public String process(BufferedReader b) throws IOException;
    }

    /**
     * Creates a credit card base on 3 Strings.
     * @param bank    Name of the bank.
     * @param cardNum Card number.
     * @param expDate Expiry Date.
     * @return the new card
     */
    static CreditCard createCard(String bank, String cardNum, String expDate) {

        CreditCard card = null;
        YearMonth expiryDate = YearMonth.parse(expDate, DateTimeFormatter.ofPattern("MMM-yyyy", Locale.UK));

        switch (bank) {
            case HSBCCanadaCard.BANK:
                card = new HSBCCanadaCard(cardNum, expiryDate);
                break;
            case RoyalBankOfCanadaCard.BANK:
                card = new RoyalBankOfCanadaCard(cardNum, expiryDate);
                break;
            case AmericanExpressCard.BANK:
                card = new AmericanExpressCard(cardNum, expiryDate);
        }

        return card;
    }

    /**
     * Writes a list of credit card to a file.
     *
     * @param fileName - Name of the file to be written
     * @param cards list of credit cards.
     * @throws IOException - If it was not possible to write to the specified
     * file.
     */
    static void writeCardsToFile(String fileName, List<CreditCard> cards) throws IOException {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName))) {
            for (CreditCard card : cards) {
                processWriteCards(br, (x) -> {
                    x.write(card.toStringWithFullCardNumber());
                    x.newLine();
                });
            }
        }
    }

    private static void processWriteCards(BufferedWriter br, BufferedWriterProcessor p) throws IOException {
        p.process(br);
    }

    @FunctionalInterface
    private interface BufferedWriterProcessor {
        public void process(BufferedWriter b) throws IOException;
    }

}

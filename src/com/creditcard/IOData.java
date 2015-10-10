package com.creditcard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class IOData {

    private IOData() {
    }

    /**
     * Reads a file containing credit cards information.
     *
     * @param fileName file to be read.
     * @return A list containing all credit cards read.
     * @throws FileNotFoundException if it was not possible to open the file
     * @throws ParseException If the file in not well formatted.
     */
    static List<CreditCard> readCardsFromFile(String fileName) throws FileNotFoundException, ParseException {

        List<CreditCard> cards = new LinkedList<>();

        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // This is here only because in the original file there is a double space in the second line.
            line = line.replaceAll("  ", " ").trim();
            
            String[] elements = line.split(",");
            if (elements.length != 3) {
                throw new ParseException("Incorrect file data.", 0);
            }

            CardValidator.validateCrediteCard(elements);
            CreditCard card = createCard(elements[0], elements[1], elements[2]);
            cards.add(card);
        }
        sc.close();

        return cards;
    }

    /**
     * Creates a credit card base on 3 Strings.
     * @param bank Name of the bank.
     * @param cardNum Card number.
     * @param expDate Expiry Date.
     * @return the new card
     */
     static CreditCard createCard(String bank, String cardNum, String expDate) {

        CreditCard card = null;
        YearMonth expiryDate = YearMonth.parse(expDate, DateTimeFormatter.ofPattern("MMM-yyyy", Locale.UK));

        switch (bank) {
            case HSBCCanadaCard.BANK: // mudar isto para consts desntro da class HB..Canada
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

        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);

        String line;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (CreditCard c : cards) {
            line = c.toStringWithFullCardNumber();
            bw.write(line);
            bw.newLine();
        }
        bw.close();

    }

}

package com.creditcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Client class which does the procedure of reading cards from the fie, sorting
 * and displaying then in the correct order/format.
 * If the file doesn't exist a big mock file is generated and used instead.
 *
 * @author Ricardo Santos
 */
public class Client {

    private final static String DEFAULT_FILE = "mid-test.csv";

    public static void main(String[] args) throws IOException, ParseException {

        String fileName = null;
        int cardsNumb = 0;

        if (args.length == 2) {
            try {
                cardsNumb = Integer.parseInt(args[1]);
                fileName = args[0];

            } catch (NumberFormatException e) {
                System.err.println("The second argument is not an integer.");
            }

            // If a name and an integer has been passed in the command line, 
            // it creates a csv file with that name, containing the number cards specified in 
            // the second argument. This cards are generated with random valid numbers
            if (fileName != null && cardsNumb > 0) {
                File f = new File(fileName);
                if (!(f.exists() && !f.isDirectory())) { /// generatr csv file with cards
                    List<CreditCard> generatedCards = CardsGenerator.generateCreditCards(cardsNumb);
                    IOData.writeCardsToFile(fileName, generatedCards);
                    processCards(fileName);
                }
            }

        } else {
            processCards(DEFAULT_FILE);
        }
    }

    private static void processCards(String fileName) throws FileNotFoundException, ParseException {
        // reads cards from the file
        List<CreditCard> cards = IOData.readCardsFromFile(fileName);

        CardsManager manager = new CardsManager();
        manager.setCards(cards);
        manager.sortCard(new DecrescenteExpiryDateComparator()); // sorts cards
        manager.output();            // prints out the sorted ist of cards
    }
}

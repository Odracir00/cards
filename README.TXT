These files contain a Netbeans project for the application CreditCard.

The CreditCard application sorts the list of credit cards defined in the mid-test.csv. 
The sorted list is printed to the screen with a descendent expiry date.

This can be done with:
1 – cd to folder where CreditCard.jar is located
2 - java -jar "CreditCard.jar"
[Note: The file "mid-test.csv" has to be placed in the same directory as the "CreditCard.jar"]

It is also possible to generate a file a with many cards with random valid data and them sort them.
This can be done passing 2 argument to the program; the first is the name of the new file, the second is the number of cards to be generated. Ex:
1 – cd to folder where CreditCard.jar is located
2 - java -jar "CreditCard.jar" new-file.csv 100000

This would create a new file with 100000 new cards. 
After this file is created, the file is read and the cards are sorted by expiry date and printed to the output.

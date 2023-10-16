package BlindMansBluff;

import java.util.Random;
import java.util.Scanner;

public class BlindMansBluff{
    // main switchboard
    public void run(){
        System.out.println("=============================\nWelcome to Blind Man's Bluff\n=============================");
        boolean play, invalid, guessedHigher = false;
        String response;
        Card compValue;
        Card userValue;
        int nWin = 0, nLoss = 0, nTie = 0;
        Scanner sc= new Scanner(System.in);
        play = true;
        Random rand = new Random();
        Deck cardDeck = new Deck();
        cardDeck.fillDeck();
        while(play) {
            // assign values to computer and user
            compValue = cardDeck.pickCard(rand.nextInt(cardDeck.availableCards()));
            userValue = cardDeck.pickCard(rand.nextInt(cardDeck.availableCards()));

            // get user's bet
            System.out.println( "Computer's value is "+ compValue.toString());
            invalid = true;
            while(invalid) {
                System.out.println( "Do you think your number is higher or lower? (H/L)");
                response=sc.next();
                if (response.toUpperCase().charAt(0) == 'H') {
                    // continue playing
                    guessedHigher = true;
                    invalid = false;
                } else if (response.toUpperCase().charAt(0) == 'L') {
                    // break out of while(play) loop
                    guessedHigher = false;
                    invalid = false;
                } else {
                    // invalid response, ask again
                    System.out.println("Invalid response...");
                    invalid = true;
                }
            }
            CardSortingComparator Compare = new CardSortingComparator();
            Compare.compare(compValue,userValue);
            // determine outcome
            if((Compare.compare(compValue,userValue) == -1 && guessedHigher) || (Compare.compare(compValue,userValue) == 1 && !guessedHigher)) {
                System.out.println("Great! You're right:");
                nWin++;
            } else if((Compare.compare(compValue,userValue) == 1 && guessedHigher) || (Compare.compare(compValue,userValue) == -1 && !guessedHigher)) {
                System.out.println("Sorry, you're wrong:");
                nLoss++;
            } else {
                System.out.println("It's a tie:");
                nTie++;
            }
            System.out.println("your value is "+ userValue);

            // ask user to play again
            invalid = true;
            while(invalid) {
                System.out.println("Play again? (Y/N)");
                response=sc.next();
                if (response.toUpperCase().charAt(0) == 'Y') {
                    // continue playing
                    play = true;
                    invalid = false;
                } else if (response.toUpperCase().charAt(0)=='N') {
                    // break out of while(play) loop
                    play = false;
                    invalid = false;
                } else {
                    // invalid response, ask again
                    System.out.println("Invalid response..." );
                    invalid = true;
                }
            }
        }

        // output stats
        System.out.println("Thanks for playing!");
        System.out.println("Your record was " + nWin + "-" + nLoss + "-" + nTie +" (W-L-T)" );
    }

    public static void main(String[] args) {

        new BlindMansBluff().run();
    }

}

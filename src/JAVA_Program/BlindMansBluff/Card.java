package JAVA_Program.BlindMansBluff;

public class Card {

    public String rank;
    public String suit;

    public Card(int rankNum, int suitNum) {
        try {
            // ranks are ordered Ace-low and Queen-high
            String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen"};
            rank = ranks[rankNum];
            // suits are ordered alphabetically
            String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
            suit = suits[suitNum];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Sorry That Rank Or Suit Is Out Of Index");
        }
    }

    public Card(String ranks, String suits) {
        rank = ranks;
        suit = suits;
    }

    public String toString() {
        return this.rank + " of " + this.suit;
    }
}

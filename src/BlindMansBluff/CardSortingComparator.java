package BlindMansBluff;

import java.util.Arrays;
import java.util.Comparator;

public class CardSortingComparator implements Comparator<Card> {
    private final String ranks[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen"};
    private final String suits[] = {"Clubs", "Diamonds", "Hearts", "Spades"};

    @Override
    public int compare(Card c1, Card c2) {
        int rankingCompare = Integer.compare(Arrays.asList(ranks).indexOf(c1.rank), Arrays.asList(ranks).indexOf(c2.rank));
        int suitCompare = Integer.compare(Arrays.asList(suits).indexOf(c1.rank), Arrays.asList(suits).indexOf(c2.rank));
        if (suitCompare == 0 && rankingCompare == 0) {
            return rankingCompare;
        } else if (rankingCompare == 0) {
            return suitCompare;
        } else {
            return rankingCompare;
        }
    }
}
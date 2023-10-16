package BlindMansBluff;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards=new ArrayList<>();
    private int arraySize;
    private int cardsLeft;

    public void fillDeck() {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {
                cards.add(new Card(i,j));
                arraySize++;
                cardsLeft++;
            }
        }
    }

    public void shuffleCards(){
        Random ran = new Random();
        while (cardsLeft > 0){
            int one = ran.nextInt(cardsLeft);
            int two = ran.nextInt(cardsLeft);
            Card temp = cards.get(one);
            cards.set(one, cards.get(two));
            cards.set(two, temp);
            cardsLeft = cardsLeft - 2;
        }
    }
    public Card pickCard(int r){
        arraySize--;
        cardsLeft--;
        return cards.get(r);
    }

    public int availableCards(){
        return cardsLeft;
    }
    public void addCard(int r, int s){
        if(arraySize != 52){
            cards.add(new Card(r,s));
        }else{
            System.out.println("You have added the maximum amount of cards in the deck.");
        }
    }
}

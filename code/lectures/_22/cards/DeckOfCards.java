package lectures._22.cards;

import java.util.ArrayList;

public class DeckOfCards
{
    public final ArrayList<Card> cards = new ArrayList<>();

    public DeckOfCards() {

        for (int i = 0; i < 52; i ++) {
            int value = i%13;

            Card.Color color;
            Card.Suit suit;

            switch(i/26) {
                case 0:
                    color = Card.Color.BLACK;
                    break;
                case 1:
                    color = Card.Color.RED;
                    break;
                default:
                    color = Card.Color.BLACK;
            }

            switch(i/13) {
                case 0:
                    suit = Card.Suit.SPADES;
                    break;
                case 1:
                    suit = Card.Suit.CLUBS;
                    break;
                case 2:
                    suit = Card.Suit.HEARTS;
                    break;
                case 3:
                    suit = Card.Suit.DIAMONDS;
                    break;
                default:
                    suit = Card.Suit.SPADES;
            };

            Card card = new Card(
                    color,
                    suit,
                    value
            );

            this.cards.add(card);
        }

        ArrayList<Card> standardDeck = new ArrayList<>();

        standardDeck.addAll(this.cards.subList(0, 13));
        standardDeck.addAll(this.cards.subList(26, 39));
        standardDeck.addAll(this.cards.subList(13, 26));
        standardDeck.addAll(this.cards.subList(39, 52));

        this.cards.clear();

        this.cards.addAll(standardDeck);
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();

        for (Card card : deck.cards) {
            System.out.println(card);
        }
    }
}

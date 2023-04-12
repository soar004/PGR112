package lectures._22.cards;

public record Card(
        Card.Color color,
        Card.Suit suit,
        int value
)
{
    public enum Suit {
        CLUBS,
        SPADES,
        HEARTS,
        DIAMONDS
    }

    public enum Color {
        RED,
        BLACK
    }
}

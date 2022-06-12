public class Card implements Comparable<Card>{

    public enum Suit{
        HEARTS, //черви
        DIAMOND, //бубни
        SPADE, //пики
        CLUB, //крести
    }

    private final static String[] VALUES = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final static String[] SUITS = {"H", "D", "C", "S"};
    private final int value; //ценность карты
    private final Suit suit; //масть карты

    public Card(int value, Suit suit){
        if(value <= 5 || value > 14)
            throw new IndexOutOfBoundsException();
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        return this.getValue() - o.getValue();
    }

    @Override
    public String toString() {
        return VALUES[value - 6] + SUITS[suit.ordinal()];
    }
}

package blackjack.model;

public enum Suit {
    DIAMONDS((char) 9826), CLUBS((char) 9827), PEAKS((char) 9824), HEARTS((char) 9825);

    private final char sign;

    Suit(char sign) {
        this.sign = sign;
    }

    public char getSign() { return sign; }
}
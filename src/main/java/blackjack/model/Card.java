package blackjack.model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Card {
    private final Suit suit;
    private final Face face;

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

//    public Suit getSuit() { return suit; }
//    public Face getFace() { return face; }

    @Override
    public String toString() {
        return face.getName() + suit.getSign();
    }
}
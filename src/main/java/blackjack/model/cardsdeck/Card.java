package blackjack.model.cardsdeck;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Card {
    private final Suit suit;
    private final Face face;

    @Override
    public String toString() {
        return face.getName() + suit.getSign();
    }
}
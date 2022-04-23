package blackjack.model.cardsdeck;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Card {
    private final Suit suit;
    private final Face face;
    private final char back;

    private boolean isOpen = true;

    @Override
    public String toString() {
        return isOpen() ? face.getName() + suit.getSign() : Character.toString(back);
    }
}
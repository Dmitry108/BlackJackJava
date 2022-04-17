package blackjack.model.cardsdeck;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Suit {
    HEARTS('\u2661'), DIAMONDS('\u2662'), CLUBS('\u2663'), PEAKS('\u2660');
    private final char sign;
}
package blackjack.model;

import java.util.List;

public interface Deck {
    void shuffle();
    Card getCard();
    void fillDeck(List<Card> cards);
}
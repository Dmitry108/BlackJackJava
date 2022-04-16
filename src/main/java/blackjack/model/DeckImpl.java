package blackjack.model;

import java.util.*;

public class DeckImpl implements Deck {
    private final Stack<Card> deck;

    /**
     * Конструктор создает игровую колоду карт
     * @param cardSetCount количество наборов карт в колоде
     */
    public DeckImpl(int cardSetCount) {
        deck = new Stack<>();
        for (int n = 0; n < cardSetCount; n++) {
            for (Suit suit : Suit.values()) {
                for (Face face : Face.values()) {
                    deck.add(new Card(suit, face));
                }
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(deck);
    }

    @Override
    public Card getCard() {
        return deck.empty() ? null : deck.pop();
    }

    @Override
    public void fillDeck(List<Card> cards) {
        deck.addAll(cards);
        shuffle();
    }

    @Override
    public String toString() {
        if (deck.empty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < deck.size() - 1; i++) {
            sb.append(deck.get(i)).append(", ");
        }
        sb.append(deck.get(deck.size() - 1)).append("]");
        return sb.toString();
    }
}

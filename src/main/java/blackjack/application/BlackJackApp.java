package blackjack.application;

import blackjack.model.*;

public class BlackJackApp {
    public static void main(String[] args) {
        Deck deck = new DeckImpl(1);
        deck.shuffle();
        Card card = deck.getCard();
        System.out.println(card);
        System.out.println(deck);
    }
}

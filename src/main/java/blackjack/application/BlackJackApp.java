package blackjack.application;

import blackjack.di.BlackJackModule;
import blackjack.model.cardsdeck.Card;
import blackjack.model.cardsdeck.Deck;
import blackjack.model.cardsdeck.DeckImpl;
import blackjack.view.GameConsoleView;

public class BlackJackApp {

    public BlackJackApp() {
        new GameConsoleView();
    }

    public static void main(String[] args) {
        new BlackJackApp();
    }
}
package blackjack.model.game;

import blackjack.model.cardsdeck.Card;
import blackjack.model.cardsdeck.Deck;
import blackjack.model.cardsdeck.DeckImpl;
import blackjack.model.players.Dealer;
import blackjack.model.players.Player;

import java.util.List;

public class GameTable {
    private List<Player> players;
    private Dealer dealer;
    private Deck deck;
    private List<Card> heap;

    private int totalCardCount;

    public GameTable(List<Player> players, Dealer dealer, int deckCount) {
        this.players = players;
        this.dealer = dealer;
        deck = new DeckImpl(deckCount);
        totalCardCount = deck.getSize();
        deck.shuffle();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void checkDeck() {
        if (deck.getSize() < totalCardCount / 3) {
            deck.fillDeck(heap);
            deck.shuffle();
        }
    }

    public void giveStartCards() {
        for (int i = 0; i < 2; i++) {
            players.forEach(player -> player.addCard(deck.getCard()));
            if (i != 0) dealer.addCard(deck.getCard());
        }
        Card card = deck.getCard();
        card.setOpen(false);
        dealer.addCard(card);
    }
}
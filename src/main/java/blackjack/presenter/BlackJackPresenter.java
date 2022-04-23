package blackjack.presenter;

import blackjack.model.players.Dealer;
import blackjack.model.players.Player;

import java.util.List;

public interface BlackJackPresenter {
    void startGame(List<Player> players, Dealer dealer);
    void prepareCircle();
    void onBetsDone();
}
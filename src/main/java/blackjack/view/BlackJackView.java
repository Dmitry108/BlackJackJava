package blackjack.view;

import blackjack.model.game.GameTable;
import blackjack.model.players.Dealer;
import blackjack.model.players.Player;
import blackjack.presenter.BlackJackPresenter;

import java.util.List;

public interface BlackJackView {
    void setPresenter(BlackJackPresenter presenter);
    void initGame();
    void startGame();
    void showTable(GameTable gameTable);

    void invitePlayersToPlaceBets(List<Player> players);
}

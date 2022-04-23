package blackjack.presenter;

import blackjack.model.game.GameTable;
import blackjack.model.players.Dealer;
import blackjack.model.players.Player;
import blackjack.view.BlackJackView;

import java.util.List;

public class GamePresenter implements BlackJackPresenter {
    private BlackJackView view;
    private GameTable gameTable;

    public GamePresenter(BlackJackView view) {
        this.view = view;
    }

    @Override
    public void startGame(List<Player> players, Dealer dealer) {
        int deckCount = players.size() / 2;
        gameTable = new GameTable(players, dealer, deckCount == 0 ? 1 : deckCount);
        view.showTable(gameTable);
        prepareCircle();
    }

    @Override
    public void prepareCircle() {
        //если нужно, перемешать колоду
        gameTable.checkDeck();
        //сделать ставки
        view.invitePlayersToPlaceBets(gameTable.getPlayers());
    }

    @Override
    public void onBetsDone() {
        //раздать карты
        gameTable.giveStartCards();
        view.showTable(gameTable);
        //каждый игрок играет руку
        gameTable.getPlayers().forEach(Player::playHand);
    }
        //диллер играет свою руку
        //итоги счета
}
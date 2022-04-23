package blackjack.view;

import blackjack.di.BlackJackViewInjector;
import blackjack.model.game.GameTable;
import blackjack.model.players.*;
import blackjack.presenter.BlackJackPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameConsoleView implements BlackJackView {

    private BlackJackPresenter presenter;
    private static final Scanner scanner = new Scanner(System.in);

    public GameConsoleView() {
        BlackJackViewInjector injector = new BlackJackViewInjector();
        injector.inject(this);
        initGame();
    }

    @Override
    public void setPresenter(BlackJackPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void initGame() {
        System.out.println("Сколько игроков?");
        int playersNumber = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= playersNumber; i++) {
            System.out.printf("Игрок №%d, введите имя и стартовый счет:%n", i);
            players.add(new PlayerHuman(scanner.next(), scanner.nextInt()));
        }
        System.out.println("Крупье, введите имя и капитал игры: ");
        Dealer dealer = new DealerHuman(scanner.next(), scanner.nextInt());
        presenter.startGame(players, dealer);
    }

    @Override
    public void startGame() {

    }

    @Override
    public void showTable(GameTable gameTable) {
        System.out.printf("Колода карт: %s%nКрупье: %s%n", gameTable.getDeck(), gameTable.getDealer());
        for (int i = 0; i < gameTable.getPlayers().size(); i++) {
            System.out.printf("Игрок №%d: %s%n", i + 1, gameTable.getPlayers().get(i));
        }
    }

    @Override
    public void invitePlayersToPlaceBets(List<Player> players) {
        System.out.println("Игроки, сделайте ставки!");
        players.forEach(player -> {
            System.out.println(player + "?");
            player.placeBet(scanner.nextInt());
        });
        presenter.onBetsDone();
    }
}
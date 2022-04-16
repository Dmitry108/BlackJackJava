package blackjack.view;

import blackjack.presenter.BlackJackPresenter;
import blackjack.presenter.GamePresenter;

public class GameConsoleView implements BlackJackView {

    private BlackJackPresenter presenter = new GamePresenter(this);

}

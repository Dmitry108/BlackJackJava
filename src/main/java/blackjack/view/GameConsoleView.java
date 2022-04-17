package blackjack.view;

import blackjack.di.BlackJackViewInjector;
import blackjack.presenter.BlackJackPresenter;

public class GameConsoleView implements BlackJackView {

    private BlackJackPresenter presenter;

    public GameConsoleView() {
        BlackJackViewInjector injector = new BlackJackViewInjector();
        injector.inject(this);
    }

    @Override
    public void setPresenter(BlackJackPresenter presenter) {
        this.presenter = presenter;
    }
}

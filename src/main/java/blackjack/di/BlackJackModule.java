package blackjack.di;

import blackjack.presenter.BlackJackPresenter;
import blackjack.presenter.GamePresenter;
import blackjack.view.BlackJackView;

public class BlackJackModule {

    private static BlackJackModule instance;
    private BlackJackPresenter blackJackPresenter;

    private BlackJackModule() { }

    public static BlackJackModule getInstance() {
        if (instance == null) {
            instance = new BlackJackModule();
        }
        return instance;
    }

    public BlackJackPresenter getPresenter(BlackJackView view) {
        if (blackJackPresenter == null) {
            blackJackPresenter = new GamePresenter(view);
        }
        return blackJackPresenter;
    }
}
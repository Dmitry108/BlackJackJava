package blackjack.presenter;

import blackjack.view.BlackJackView;

public class GamePresenter implements BlackJackPresenter {
    private BlackJackView view;

    public GamePresenter(BlackJackView view) {
        this.view = view;
    }
}

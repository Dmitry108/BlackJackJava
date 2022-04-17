package blackjack.di;

import blackjack.view.BlackJackView;

public class BlackJackViewInjector {

    public void inject(BlackJackView view) {
        view.setPresenter(BlackJackModule.getInstance().getPresenter(view));
    }
}
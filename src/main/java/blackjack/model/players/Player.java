package blackjack.model.players;

import blackjack.model.cardsdeck.Card;
import blackjack.model.cardsdeck.Face;

import java.util.*;

public abstract class Player {

    protected String name;
    protected int bankroll;
    protected List<Card> hand;
    protected int ante;
    protected int score;

    public Player(String name, int money) {
        this.name = name;
        this.bankroll = money;
        hand = new ArrayList<>();
    }

    public void placeBet(int bet) {
        ante = Math.min(bet, bankroll);
        bankroll -= ante;
    }

    public void addCard(Card card) {
        hand.add(card);
        score = calculateHand(hand);
    }

    public static int calculateHand(List<Card> hand) {
        ArrayList<Integer> scoreList = new ArrayList<>();
        scoreList.add(0);
        for (Card card : hand) {
            if (card.isOpen()) {
                if (card.getFace().equals(Face.ACE)) {
                    ArrayList<Integer> aa = new ArrayList<>(scoreList);
                    incListElements(scoreList, 1);
                    incListElements(aa, 11);
                    scoreList.addAll(aa);
                } else {
                    switch (card.getFace()) {
                        case TWO -> incListElements(scoreList, 2);
                        case THREE -> incListElements(scoreList, 3);
                        case FOUR -> incListElements(scoreList, 4);
                        case FIVE -> incListElements(scoreList, 5);
                        case SIX -> incListElements(scoreList, 6);
                        case SEVEN -> incListElements(scoreList, 7);
                        case EIGHT -> incListElements(scoreList, 8);
                        case NINE -> incListElements(scoreList, 9);
                        case TEN, JACK, QUEEN, KING -> incListElements(scoreList, 10);
                    }
                }
            }
        }
        int score = 0;
        if (scoreList.size() > 1) {
            for (int num : scoreList) {
                if (num > score && num <= 21) score = num;
            }
        }
        if (score == 0) score = scoreList.get(0);
        return score;
    }

    private static void incListElements(ArrayList<Integer> list, int inc) {
        list.replaceAll(integer -> integer + inc);
    }

    abstract public void playHand();

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return String.format("%s, банк - %d%s%s", name, bankroll,
                ante == 0 ? "" : ", ставка - " + ante,
                hand.isEmpty() ? "" : String.format(", рука - %s (%d)", hand, score));
    }
}
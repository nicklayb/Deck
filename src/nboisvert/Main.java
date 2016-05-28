package nboisvert;

import nboisvert.Deckar.Card.Face;
import nboisvert.Deckar.Card.Number;

import nboisvert.Deckar.Card.Card;
import nboisvert.Deckar.Deck;
import nboisvert.Deckar.Set;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Set set = new Set();

        set.insertCard(deck.withdrawRandomCard());
    }
}

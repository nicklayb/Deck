package nboisvert.Deckar;

import nboisvert.Deckar.Card.*;
import nboisvert.Deckar.Card.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Nicolas Boisvert on 2016-05-28.
 */
public class Deck extends Set{
    protected boolean jokers;
    protected int deckCount;

    public Deck(){
        this.cards = new ArrayList<>();
        this.jokers = false;
        this.deckCount = 1;
        for(Face face : Face.values()) {
            if (face != Face.BLACKJOKER && face != Face.REDJOKER){
                for (Number number : Number.values()) {
                    if (number != Number.JOKER) {
                        this.cards.add(new Card(face, number));
                    }
                }
            }
        }
    }

    public Deck(int count){
        this.cards = new ArrayList<>();
        this.jokers = false;
        this.deckCount = count;
        for(int i = 0; i < this.deckCount; i++) {
            for (Face face : Face.values()) {
                if (face != Face.BLACKJOKER && face != Face.REDJOKER) {
                    for (Number number : Number.values()) {
                        if (number != Number.JOKER) {
                            this.cards.add(new Card(face, number));
                        }
                    }
                }
            }
        }
    }

    public int getDeckCount() {
        return deckCount;
    }

    public void addJokers(){
        for(int i = 0; i < this.deckCount; i++) {
            this.cards.add(new Card(Face.BLACKJOKER, Number.JOKER));
            this.cards.add(new Card(Face.REDJOKER, Number.JOKER));
        }
        this.jokers = true;
    }

    public void removeJokers(){
        int[] jokerIndexes = new int[this.countAllJokers()];
        int count = 0;
        for(int i = 0; i < this.count(); i++){
            if(this.showCard(i).getFace() == Face.BLACKJOKER || this.showCard(i).getFace() == Face.REDJOKER){
                jokerIndexes[count++] = i;
            }
        }
        for(int i = this.countAllJokers()-1; i >= 0; i--){
            this.withdrawCard(jokerIndexes[i]);
        }
        this.jokers = false;
    }

    public int countAllJokers(){
        return (this.hasJoker()) ? this.deckCount * 2 : 0;
    }

    public int countJokers(){
        return this.count(Number.JOKER);
    }

    public boolean hasJoker(){
        return this.jokers;
    }

    public void insertCard(Card card){
        if(this.count(card) < this.deckCount){
            this.cards.add(card);
        }
    }

    public void insertCard(List<Card> cards){
        for(Card card : cards){
            if(this.count(card) < this.deckCount){
                this.cards.add(card);
            }
        }
    }
}

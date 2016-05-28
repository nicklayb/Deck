package nboisvert.Deckar;

import nboisvert.Deckar.Card.Card;
import nboisvert.Deckar.Card.Face;
import nboisvert.Deckar.Card.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Nicolas Boisvert on 2016-05-28.
 */
public class Set {
    protected List<Card> cards;

    public Set(){
        this.cards = new ArrayList<>();
    }

    public boolean containsCard(Card lookupCard){
        for(Card card : this.cards){
            if(card.equals(lookupCard)){
                return true;
            }
        }
        return false;
    }

    public int findCard(Card lookupCard){
        for(int i = 0; i < this.count(); i++){
            if(this.cards.get(i).equals(lookupCard)){
                return i;
            }
        }
        return -1;
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public void shuffle(int amount){
        for(int i = 0; i < amount; i++){
            this.shuffle();
        }
    }

    public int count(){
        return this.cards.size();
    }

    public int count(Face face){
        int count = 0;
        for(Card card : this.cards){
            count += (card.getFace() == face) ? 1 : 0;
        }
        return count;
    }

    public int count(Card lookupCard){
        int count = 0;
        for(Card card : this.cards){
            count += (card.equals(lookupCard)) ? 1 : 0;
        }
        return count;
    }

    public int count(Number number){
        int count = 0;
        for(Card card : this.cards){
            count += (card.getNumber() == number) ? 1 : 0;
        }
        return count;
    }

    public int getRandomCardIndex() {
        Random random = new Random();
        return random.nextInt(this.count())-1;
    }

    public Card showRandomCard(){
        return this.showCard(this.getRandomCardIndex());
    }

    public Card showTopCard(){
        Card card = this.cards.get(this.topCardIndex());
        return card;
    }

    public Card showBottomCard(){
        Card card = this.cards.get(this.bottomCardIndex());
        return card;
    }

    public Card showCard(int index){
        Card card = this.cards.get(index);
        return card;
    }

    public Card withdrawTopCard(){
        Card card = this.cards.get(this.topCardIndex());
        this.cards.remove(this.topCardIndex());
        return card;
    }

    public Card withdrawBottomCard(){
        Card card = this.cards.get(this.bottomCardIndex());
        this.cards.remove(this.bottomCardIndex());
        return card;
    }

    public Card withdrawCard(int index){
        Card card = this.cards.get(index);
        this.cards.remove(index);
        return card;
    }

    public Card withdrawCard(Card card){
        int index = this.findCard(card);
        if(index > -1){
            return this.withdrawCard(index);
        }
        return null;
    }

    public Card withdrawRandomCard(){
        return this.withdrawCard(this.getRandomCardIndex());
    }

    public List<Card> withdrawRandomCard(int amount){
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            cards.add(this.withdrawCard(this.getRandomCardIndex()));
        }
        return cards;
    }

    public int topCardIndex(){
        return this.cards.size()-1;
    }

    public int bottomCardIndex(){
        return 0;
    }

    public String toString(){
        String output = "";
        int count = this.count();
        for(Card card : this.cards){
            output += card.toString()+"\n";
        }
        output += count + " card" + ((count > 1) ? "s" : "") + " in deck";
        return output;
    }

    public void insertCard(Card card){
        this.cards.add(card);
    }

    public void insertCard(List<Card> cards){
        for(Card card : cards){
            this.cards.add(card);
        }
    }
}

package nboisvert.Deckar.Card;

import nboisvert.Deckar.Card.Color;

/**
 * Created by Nicolas Boisvert on 2016-05-28.
 */
public enum Face {
    CLUB("Club", Color.BLACK),DIAMOND("Diamond", Color.RED),HEART("Heart", Color.RED),SPADE("Spade", Color.BLACK), REDJOKER("Red Joker", Color.RED), BLACKJOKER("Black Joker", Color.BLACK);

    public String name;
    public Color color;

    Face(String name, Color color){
        this.name = name;
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public String toString(){
        return this.name;
    }
}

package nboisvert.Deckar.Card;

/**
 * Created by Nicolas Boisvert on 2016-05-28.
 */
public enum Number {
    ACE("Ace", 1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK("Jack", 11),QUEEN("Queen", 12),KING("King", 13),JOKER("Joker", -1);

    public int value;
    public String name;

    Number(int value){
        this.value = value;
        this.name = "";
    }

    Number(String name, int value){
        this.value = value;
        this.name = name;
    }

    public int getValue(){
        return this.value;
    }

    public String toString(){
        return (this.hasName()) ? this.getName() : String.valueOf(this.getValue());
    }

    public String getName(){
        return this.name;
    }

    public boolean hasName(){
        return !this.getName().equals("");
    }
}

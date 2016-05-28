package nboisvert.Deckar.Card;

/**
 * Created by Nicolas Boisvert on 2016-05-28.
 */
public class Card implements Comparable {
    protected Face face;
    protected Number number;

    public Card(Face face, Number number){
        this.setFace(face);
        this.setNumber(number);
    }

    public Face getFace() {
        return face;
    }

    public Number getNumber() {
        return number;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public void setNumber(Number number) {
        this.number = ((this.getFace() == Face.BLACKJOKER || this.getFace() == Face.REDJOKER) ? Number.JOKER : number);
    }

    public boolean isSameNumber(Card card){
        return (this.getNumber() == card.getNumber());
    }

    public boolean isSameFace(Card card){
        return (this.getFace() == card.getFace());
    }

    public boolean isSameColor(Card card){
        return (this.getFace().getColor() == card.getFace().getColor());
    }

    public boolean isGreaterThan(Card card){
        return (this.compareTo(card) == 1);
    }

    public boolean isLessThan(Card card){
        return (this.compareTo(card) == -1);
    }

    @Override
    public boolean equals(Object obj) {
        Card comparedCard = (Card)obj;
        return (this.isSameFace(comparedCard) && this.isSameNumber(comparedCard));
    }

    @Override
    public int compareTo(Object o) {
        Card comparedCard = (Card)o;
        if(comparedCard.getNumber().getValue() > this.getNumber().getValue()){
            return -1;
        }
        else if(comparedCard.getNumber().getValue() < this.getNumber().getValue()){
            return 1;
        }
        return 0;
    }

    public String toString(){
        return this.face.toString()+"\t"+this.number.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static Card joker(Face face){
        return new Card(face, Number.JOKER);
    }
}

# Deck
###### By Nicolas Boisvert :: nicklay@me.com

## Information
Deck is a **Java** library to play with cards. Yup, you read well. Actually, it's supposed to make card game creation easier than starting from scratch. It helps you to manage a deck, a lot of decks, sets and hands. This is only a skeleton... Well, not really a skeleton but much more like a "bone set". You could connect them to make any kind of creature.

## Purposes
You may you use it for whatever you want. Making a program/library for a particular use is a bad practice in programming so feel to test de limit of the library which are, for the moment, obviously present.

If your teachers asks you to make a poker game for example, you'll save a lot of time checking out this.

## Usage
### Enumerator and stuff
#### Faces
The card's faces are in an enum called ```Face```. In it you'll find those : ```DIAMOND```, ```SPADE```, ```HEART```, ```CLUB```, ```REDJOKER``` and ```BLACKJOKER```.

#### Numbers
The numbers are not only like 1,2,3... They are what they have to be. There's another enum for the numbers called ```Number``` which contains : ```ACE```, ```TWO```, ```THREE```, ```FOUR```, ```FIVE```, ```SIX```, ```SEVEN```, ```EIGHT```, ```NINE```, ```TEN```, ```JACK```, ```QUEEN```, ```KING``` and  ```JOKER``` which all contains a value equals from 1 to 13.

### A "Card"
A ```Card``` is a simple object containing a Face and a Number (Diamond and Ace for example). The card object are comparable and be evaluated easily by the Number's value. They can be compared by their face, their number or the card itself.
```java
Card card1 = new Card(Face.DIAMOND, Number.ACE); // We now have a Diamond Ace
Card card2 = new Card(Face.SPADE, Number.ACE); // We now have a Spade Ace

card1.equals(card2);        //  Will return false, since the face is not the same
card1.isSameNumber(card2);  //  Will return true
card1.compareTo(card2);     //  Will return 0, the number is the same
```

#### Joker's card
If you try to make a Joker card. You have to put the matching Face in the constructor. Try to put the Joker's number  in the number but no matter what you put, if the face is a joker face, the number will be the Joker.
```java
Card card1 = new Card(Face.REDJKOKER, Number.JOKER); // Thw way of doing it
Card card2 = new Card(Face.REDJOKER, Number.ACE); // Will become Joker anyway but it's not the best way of doing it
```

### Playing with a card set
Basically, the card set don't any validation method. You could but 5 thousands card of the Diamond Ace and no one would care. Instantiating a Set does not include any card, it's just a box where you'll put card.
```java
Set set = new Set();
set.count() //  Will returns 0
```

#### Insert card
Let's take the Diamond Ace we made sooner and insert it into the set
```java
set.insertCard(card1) //  Set will now contain a Diamond Ace
```
The insertCard method could also receive a List<Card> and will insert them all.

#### Withdraw/show card
The class implementation has a lot of withdraw/show alternatives. But basically, the only difference between withdrawing and showing a card is that withdrawing will remove the card from the set.
```java
set.withdrawTopCard(); //   Will return the top card and remove it from the set
set.withdrawBottomCard(); //   Will return the bottom card and remove it from the set
set.withdrawCard(2); //   Will return the card at index 2 and remove it from the set
set.withdrawTopCard(new Card(Face.DIAMOND, Number.ACE)); //   Will return the first Diamond Ace it founds and remove it from the set
set.withdrawRandomCard(); //   Will return a random card and remove it from the set
set.withdrawRandomCard(5); //   Will return a List<Card> of 5 random cards and remove it from the set
set.withdrawAllCard(); //   Will return a List<Card> of all the cards and remove it from the set
```

You can replace the word "withdraw" by the word "show" of any of those method to do the exact same thing but by leaving the card in the set.

#### Counting the cards
Even though casinos don't want you to do it, the Deck library let's you do it easily.
```java
set.count(); // Count all the cards
set.count(Face.DIAMOND); // Count all the diamonds cards
set.count(Number.ACE); // Count all the aces cards
set.count(new Card(Face.DIAMOND, Number.ACE)); // Count all the diamond aces cards
```

#### Shuffling the thing
Sometimes, maybe all time actually, you'll want the deck to be shuffled to prevent cheating and unfair playing. This is how you can do it.
```java
set.shuffle(); // Will shuffle the Set once
set.shuffle(10); // Will shuffle the Set ten times
```

#### Lookup and researches
The set also has two method to look at the deck
```java
Card card = new Card(Face.DIAMOND, Number.ACE); // The card I want
set.containsCard(card); // Will return true or false if the card is in the set
set.findCard(card); // Will return the index of the card if it's contained in the set, may return -1 if not.
```


### Making a Deck
A Deck extends all of the ```Set``` method's.

```java
Deck deck = new Deck();
deck.count() //  Will returns 52
```
The deck is done. It now contains 52 cards, 13 for all faces. But let suppose that your game needs a deck of two deck (like 104 cards). Oh my god, how can I do that? Look at this.
```java
Deck deck = new Deck(2);
deck.count() //  Will returns 104
```
Yup, it's that easy. Since the deck extends the Set class, you can also use the ```Set```. Using a Deck will prevent you to mistakenly add twice the same card in the Deck.

#### Using jokers
The default deck doesn't include jokers, to do so, call the method ```.addJokers()``` within your Deck. If your deck only has one deck and you call the method twice, the deck will don't add double red and black jokers by default.

If you want to remove em after adding them you can call the ```.removeJokers()``` method within your Deck. But be careful, if you add jokers, then withdraw em from the deck, then remove the jokers from the deck. The deck won't accept them back until you call the addJokers method.




## Conclusion

Thank you for using it and feel free to contact me for any question.

Ending joke :
> An SQL query walks up to two tables in a restaurant and asks: "Mind if I join you?"

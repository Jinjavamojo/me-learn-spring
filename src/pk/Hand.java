package pk;

/**
 * Copyright 2016 LANIT group.
 * http://www.lanit.ru/
 * <p/>
 * Repository path:    $HeadURL$
 * Last committed:     $Revision$
 * Last changed by:    $Author$
 * Last changed date:  $Date$
 * ID:                 $Id$
 */
public class Hand {

    private int number;
    private Card firstCard;
    private Card secondCard;
    private Combination combination;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Combination getCombination() {
        return combination;
    }

    public void setCombination(Combination combination) {
        this.combination = combination;
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(Card firstCard) {
        this.firstCard = firstCard;
    }

    public Card getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(Card secondCard) {
        this.secondCard = secondCard;
    }
}

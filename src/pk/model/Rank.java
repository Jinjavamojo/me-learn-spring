package pk.model;


import pk.combinations.Street;

public enum  Rank implements Comparable<Rank> {
    TWO(2,"2"),
    THREE(3,"3"),
    FOUR(4,"4"),
    FIVE(5,"5"),
    SIX(6,"6"),
    SEVEN(7,"7"),
    EIGHT(8,"8"),
    NINE(9,"9"),
    TEN(10,"10"),
    JACK(11,"J"),
    QUEEN(12,"Q"),
    KING(13,"K"),
    ACE(14,"A");
    private int value;
    private String display;

    Rank(int value,String display) {
        this.value = value;
        this.display = display;
    }

    @Override
    public String toString() {
        return display;
    }

    public int getValue() {
        return value;
    }


}

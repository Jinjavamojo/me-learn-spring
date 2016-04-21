package pk.model;


public enum Mast {
    CHERVI(0,"❤"),
    BUBI(1000,"♦"),
    PIKI(2000,"♠"),
    KRESTI(3000,"♣");     //❇


    int value;
    String display;

    Mast(int value, String display) {
        this.value = value;
        this.display = display;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        return display;
    }
}

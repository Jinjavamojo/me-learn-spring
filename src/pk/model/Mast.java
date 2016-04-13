package pk.model;


public enum Mast {
    CHERVI(0),
    BUBI(1000),
    PIKI(2000),
    KRESTI(3000);

    int value;

    Mast(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

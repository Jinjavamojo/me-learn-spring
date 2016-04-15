package pk.model;

/**
 * Created by Денис on 14.04.2016.
 */
public class CardCoordinate {

    int row;
    int col;

    public CardCoordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int hashCode() {
        return (row*1000) + col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CardCoordinate) {
            CardCoordinate cardCoordinate = (CardCoordinate)obj;
            return row == cardCoordinate.row && col == cardCoordinate.col;
        }
        return false;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

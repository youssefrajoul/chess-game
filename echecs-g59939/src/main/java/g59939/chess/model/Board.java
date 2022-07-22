package g59939.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g59939
 */
public class Board {

    private final Square tableau[][];

    public Board() {
        tableau = new Square[8][8];
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                tableau[i][j] = new Square(null);
            }
        }
    }

    public boolean contains(Position pos) {
        return !(pos.getRow() > 7 || pos.getRow() < 0 || pos.getColumn() > 7 || pos.getColumn() < 0);
    }

    public void setPiece(Piece piece, Position position) {
        tableau[position.getRow()][position.getColumn()].setPiece(piece);
    }

    public Piece getPiece(Position pos) {
        return tableau[pos.getRow()][pos.getColumn()].getPiece();
    }

    public int getInitialPawnRow(Color color) {
        if (color == Color.WHITE) {
            return 1;
        } else {
            return 6;
        }
    }

    public void dropPiece(Position pos) {
        tableau[pos.getRow()][pos.getColumn()].setPiece(null);
    }

    public boolean isFree(Position pos) {
        return tableau[pos.getRow()][pos.getColumn()].isFree();
    }

    public boolean containsOppositeColor(Position pos, Color col) {
        return (tableau[pos.getRow()][pos.getColumn()].getPiece().getColor() == col.opposite());
    }

    public List<Position> getPositionsOccupiedBy(Player player) {
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j].getPiece().getColor() == player.getColor()) {
                    Position pos = new Position(i, j);
                    list.add(pos);
                }
            }
        }
        return list;
    }

}

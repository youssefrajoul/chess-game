package g59939.chess.model.pieces;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Direction;
import g59939.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g59939
 */
public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    /**
     *
     * @param position
     * @param board
     * @return
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMovesList = new ArrayList<>();

        directionNordEstNord(position, board, possMovesList);
        directionNordEstEst(position, board, possMovesList);
        directionNordWestNord(position, board, possMovesList);
        directionNordWestWest(position, board, possMovesList);
        directionSudEstSud(position, board, possMovesList);
        directionSudEstEst(position, board, possMovesList);
        directionSudWestSud(position, board, possMovesList);
        directionSudWestWest(position, board, possMovesList);
        return possMovesList;
    }

    /**
     *
     * @param position
     * @param board
     * @param possMovesList
     */
    private void directionNordEstNord(Position position, Board board, List<Position> possMovesList) {
        Position posNEN = position.next(Direction.NE).next(Direction.N);
        if (board.contains(posNEN) && board.isFree(posNEN)) {
            possMovesList.add(posNEN);
        }
        if (board.contains(posNEN) && !board.isFree(posNEN) && getColor() != board.getPiece(posNEN).getColor()) {
            possMovesList.add(posNEN);
        }
    }

    private void directionNordEstEst(Position position, Board board, List<Position> possMovesList) {
        Position posNEE = position.next(Direction.NE).next(Direction.E);
        if (board.contains(posNEE) && board.isFree(posNEE)) {
            possMovesList.add(posNEE);
        }
        if (board.contains(posNEE) && !board.isFree(posNEE) && getColor() != board.getPiece(posNEE).getColor()) {
            possMovesList.add(posNEE);
        }
    }

    private void directionNordWestNord(Position position, Board board, List<Position> possMovesList) {
        Position posNWN = position.next(Direction.NW).next(Direction.N);
        if (board.contains(posNWN) && board.isFree(posNWN)) {
            possMovesList.add(posNWN);
        }
        if (board.contains(posNWN) && !board.isFree(posNWN) && getColor() != board.getPiece(posNWN).getColor()) {
            possMovesList.add(posNWN);
        }
    }

    private void directionNordWestWest(Position position, Board board, List<Position> possMovesList) {
        Position posNWW = position.next(Direction.NW).next(Direction.W);
        if (board.contains(posNWW) && board.isFree(posNWW)) {
            possMovesList.add(posNWW);
        }
        if (board.contains(posNWW) && !board.isFree(posNWW) && getColor() != board.getPiece(posNWW).getColor()) {
            possMovesList.add(posNWW);
        }
    }

    private void directionSudEstSud(Position position, Board board, List<Position> possMovesList) {
        Position posSES = position.next(Direction.SE).next(Direction.S);
        if (board.contains(posSES) && board.isFree(posSES)) {
            possMovesList.add(posSES);
        }
        if (board.contains(posSES) && !board.isFree(posSES) && getColor() != board.getPiece(posSES).getColor()) {
            possMovesList.add(posSES);
        }
    }

    private void directionSudEstEst(Position position, Board board, List<Position> possMovesList) {
        Position posSEE = position.next(Direction.SE).next(Direction.E);
        if (board.contains(posSEE) && board.isFree(posSEE)) {
            possMovesList.add(posSEE);
        }
        if (board.contains(posSEE) && !board.isFree(posSEE) && getColor() != board.getPiece(posSEE).getColor()) {
            possMovesList.add(posSEE);
        }
    }

    private void directionSudWestSud(Position position, Board board, List<Position> possMovesList) {
        Position posSWS = position.next(Direction.SW).next(Direction.S);
        if (board.contains(posSWS) && board.isFree(posSWS)) {
            possMovesList.add(posSWS);
        }
        if (board.contains(posSWS) && !board.isFree(posSWS) && getColor() != board.getPiece(posSWS).getColor()) {
            possMovesList.add(posSWS);
        }
    }

    private void directionSudWestWest(Position position, Board board, List<Position> possMovesList) {
        Position posSWW = position.next(Direction.SW).next(Direction.W);
        if (board.contains(posSWW) && board.isFree(posSWW)) {
            possMovesList.add(posSWW);
        }
        if (board.contains(posSWW) && !board.isFree(posSWW) && getColor() != board.getPiece(posSWW).getColor()) {
            possMovesList.add(posSWW);
        }
    }
}

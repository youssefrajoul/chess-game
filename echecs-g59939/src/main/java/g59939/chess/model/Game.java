package g59939.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HONOR
 */
public class Game implements Model {

    private final Board board;
    private final Player white;
    private final Player black;
    private Player currentPlayer;

    public Game() {
        this.board = new Board();
        this.white = new Player(Color.WHITE);
        this.black = new Player(Color.BLACK);
    }

    @Override
    public void start() {
        this.currentPlayer = new Player(Color.WHITE);
        Piece PB = new Piece(Color.WHITE);
        Piece PN = new Piece(Color.BLACK);
        for (int i = 0; i < 8; i++) {
            board.setPiece(PB, new Position(board.getInitialPawnRow(Color.WHITE), i));
            board.setPiece(PN, new Position(board.getInitialPawnRow(Color.BLACK), i));
        }

    }

    @Override
    public Piece getPiece(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("Position out of the Board !!!");
        }
        return board.getPiece(pos);
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public Player getOppositePlayer() {
        if (this.currentPlayer == this.white) {
            return this.black;
        } else {
            return this.white;
        }
    }

    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("Position out of the Board !!!");
        }else {
            return board.getPiece(pos).getColor() == currentPlayer.getColor();
        }
    }

    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if (!board.contains(oldPos) || !board.contains(newPos)) {
            throw new IllegalArgumentException("Position out of the Board !!!");
        }
        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("Old Position is free !!!");
        }
        if (!isCurrentPlayerPosition(oldPos)){
            throw new IllegalArgumentException("the piece doesn't belong to the current player !!!");
        }
        if (!board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)){
            throw new IllegalArgumentException("the move is not valid !!!");
        }
        board.setPiece(getPiece(oldPos), oldPos);
        board.dropPiece(oldPos);
        if (!isGameOver()) {
            currentPlayer = getOppositePlayer();
        }
    }

    @Override
    public boolean isGameOver() {
        //if one of the players has no pawn left, return true(game is over)
        return board.getPositionOccupiedBy(black).isEmpty() || board.getPositionOccupiedBy(white).isEmpty();
    }

    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }

}

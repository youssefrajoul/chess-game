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
        
        white = new Player(Color.WHITE);
        black = new Player(Color.BLACK);
        board = new Board();
    }

    @Override
    public void start() {
        currentPlayer = white;
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
        return currentPlayer;
    }

    @Override
    public Player getOppositePlayer() {
        if (this.currentPlayer == this.white) {
            return black;
        } else {
            return white;
        }
    }

    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("!!! Position out of the Board !!!");
        }else {
            return board.getPiece(pos).getColor() == currentPlayer.getColor();
        }
    }

    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if (!board.contains(oldPos) || !board.contains(newPos)) {
            throw new IllegalArgumentException("old Position or new Position are not located on the board !!!");
        }
        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("Old Position isEmpty !!!");
        }
        if (!isCurrentPlayerPosition(oldPos)){
            throw new IllegalArgumentException("the piece doesn't belong to the current player !!!");
        }
        if (!board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)){
            throw new IllegalArgumentException("the move is not valid !!!");
        }
        board.setPiece(board.getPiece(oldPos), newPos);
        board.dropPiece(oldPos);
        if (!isGameOver()) {
            currentPlayer = getOppositePlayer();
        }
    }

    @Override
    public boolean isGameOver() {
        List<Position> PossibleMoves = board.getPositionOccupiedBy(currentPlayer);
        boolean isgameover = false;
        for(int i = 0; i < PossibleMoves.size() ; i++){
            if(getPossibleMoves(PossibleMoves.get(i)).isEmpty()){
                isgameover = true;
            }
        }
        return isgameover;
    }

    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }

}

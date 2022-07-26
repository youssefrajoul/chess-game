package g59939.chess.model;

import java.util.*;

/**
 *
 * @author g59939
 */
public class Game implements Model {

    private Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;

    public Game() {
        white = new Player(Color.WHITE);
        black = new Player(Color.BLACK);
        board = new Board();
    }

    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    @Override
    public void start() {
        for (int i = 0; i < 8; i++) {
            Piece whitePiece = new Piece(Color.WHITE);
            Piece blackPiece = new Piece(Color.BLACK);
            board.setPiece(whitePiece, new Position(board.getInitialPawnRow(Color.WHITE), i));
            board.setPiece(blackPiece, new Position(board.getInitialPawnRow(Color.BLACK), i));
        }
        currentPlayer = white;
    }

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos is not located on the board.
     */
    @Override
    public Piece getPiece(Position pos) {
        return board.getPiece(pos);
    }

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    @Override
    public Player getOppositePlayer() {
        if (getCurrentPlayer().getColor() == Color.WHITE) {
            return black;
        }
        return white;
    }

    /**
     * Check if the square at the given position is occupied by a piece of the
     * current player.
     *
     * @param pos the position
     * @return true if the position is occupied by a piece of the current
     * player, false otherwise.
     * @throws IllegalArgumentException if the position is not located on the
     * board.
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        return !board.containsOppositeColor(pos, getCurrentPlayer().getColor());
    }

    /**
     * Moves a piece from one position of the chess board to another one. If the
     * game is not over, change the current player.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if 1) oldPos or newPos are not located
     * on the board, or 2) oldPos does not contain a piece, or 3) the piece does
     * not belong to the current player, or 4) the move is not valid for the
     * piece located at position oldPos
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        board.dropPiece(oldPos);
        board.setPiece(board.getPiece(oldPos), newPos);
        if (!isGameOver()) {
            currentPlayer = getOppositePlayer();
        }
    }

    /**
     * Check if the game is over or not
     *
     * @return true if the game is over, false otherwise.
     */
    @Override
    public boolean isGameOver() {
        List<Position> list1;
        list1 = new ArrayList<>();
        List<Position> list2;
        list2 = new ArrayList<>();
        list1 = board.getPositionsOccupiedBy(getCurrentPlayer());
        for (int i = 0; i < list1.size(); i++) {
            list2 = board.getPiece(list1.get(i)).getPossibleMoves(list1.get(i), board);
        }
        return list2.isEmpty();
    }

    /**
     * Get the possible moves for the piece located at the specified position.
     *
     * @param position the position of the piece
     * @return the list of admissible positions.
     */
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }
}

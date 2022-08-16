package g59939.chess.model;

import g59939.chess.model.pieces.Bishop;
import g59939.chess.model.pieces.King;
import g59939.chess.model.pieces.Knight;
import g59939.chess.model.pieces.Pawn;
import g59939.chess.model.pieces.Piece;
import g59939.chess.model.pieces.Queen;
import g59939.chess.model.pieces.Rook;
import g59939.chess.view.TextView;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author g59939
 */
public class Game implements Model {

    private final Board board;
    private final Player white;
    private final Player black;
    private Player currentPlayer;
    private King whiteKing;
    private King blackKing;
    private GameState state;

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
            Piece whitePawn = new Pawn(Color.WHITE);
            Piece blackPawn = new Pawn(Color.BLACK);
            board.setPiece(whitePawn, new Position(board.getInitialPawnRow(Color.WHITE), i));
            board.setPiece(blackPawn, new Position(board.getInitialPawnRow(Color.BLACK), i));
        }
        Piece whiteRook = new Rook(Color.WHITE);
        Piece whiteKnight = new Knight(Color.WHITE);
        Piece whiteBishop = new Bishop(Color.WHITE);
        Piece whiteQueen = new Queen(Color.WHITE);
        whiteKing = new King(Color.WHITE);
        List<Piece> whitePieces = List.of(whiteRook, whiteKnight, whiteBishop, whiteQueen, whiteKing, whiteBishop, whiteKnight, whiteRook);
        Piece blackRook = new Rook(Color.BLACK);
        Piece blackKnight = new Knight(Color.BLACK);
        Piece blackBishop = new Bishop(Color.BLACK);
        Piece blackQueen = new Queen(Color.BLACK);
        blackKing = new King(Color.BLACK);
        List<Piece> blackPieces = List.of(blackRook, blackKnight, blackBishop, blackQueen, blackKing, blackBishop, blackKnight, blackRook);
        for (int i = 0; i < blackPieces.size(); i++) {
            board.setPiece(blackPieces.get(i), new Position(7, i));
        }
        for (int i = 0; i < whitePieces.size(); i++) {
            board.setPiece(whitePieces.get(i), new Position(0, i));
        }
        state = GameState.PLAY;
        currentPlayer = white;
    }

    /**
     * Gets the current state of the game
     *
     * @return the state
     */
    @Override
    public GameState getState() {
        return state;
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
        try {
            if (!board.contains(pos)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("getPiece Class Game Error, The Position is out of board");
        }
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
        try {
            if (!board.contains(pos)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("isCurrentPlayerPosition Class Game Error, The Position is out of board");
        }
        return board.getPositionsOccupiedBy(currentPlayer).contains(pos);
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
     * piece located at position oldPos Delete prints !!!
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        try {
            if (!board.contains(oldPos)) {
                throw new IllegalArgumentException();
            }
            if (!board.contains(newPos)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
        }
        try {
            if (!board.isFree(oldPos)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
        }
        try {
            if (getCurrentPlayer().getColor() != board.getPiece(oldPos).getColor()) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
        }
        try {
            if (!getPossibleMoves(oldPos).contains(newPos)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
        }
        if (board.contains(oldPos) && board.contains(newPos)) {
            System.out.println(getState());
            board.setPiece(board.getPiece(oldPos), newPos);
            board.dropPiece(oldPos);

            if (isValidMove(oldPos, newPos)) {
                if (getCapturePositions(getCurrentPlayer()).contains(board.getPiecePosition(getOppositeKing()))
                        && getCapturePositions(getCurrentPlayer()).containsAll(getPossibleMoves(board.getPiecePosition(getOppositeKing())))
                        && !getCapturePositions(getOppositePlayer()).contains(newPos)) {

                    state = GameState.CHECK_MATE;

                } else if (getCapturePositions(currentPlayer).containsAll(getPossibleMoves(board.getPiecePosition(getOppositeKing())))
                        && !getCapturePositions(getCurrentPlayer()).contains(board.getPiecePosition(getOppositeKing()))) {
                    state = GameState.STALE_MATE;

                } else if (getCapturePositions(currentPlayer).contains(board.getPiecePosition(getOppositeKing()))) {
                    state = GameState.CHECK;

                } else {
                    state = GameState.PLAY;

                }
                currentPlayer = getOppositePlayer();
            } else {
                board.setPiece(board.getPiece(newPos), oldPos);
                board.dropPiece(newPos);
                System.out.println("Wrong Mouvment");
            }
        }
    }


    /**
     * Get the possible moves for the piece located at specified position.
     *
     * @param position the current position of the piece
     * @return the list of admissible positions.
     */
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }

    /**
     * Check if the move is valid or not
     *
     * @param oldPos the current position of the piece
     * @param newPos the next possible position of the piece that we want to
     * check
     * @return true if the move can be done or false otherwise
     */
    @Override
    public boolean isValidMove(Position oldPos, Position newPos) {
        try {
            if (board.isFree(oldPos)) {
                throw new IllegalArgumentException("Error is validMove old pos is free");
            }
        } catch (Exception e) {
        }
        try {
            if (!getPossibleMoves(oldPos).contains(newPos)) {
                throw new IllegalArgumentException("Error is validMove getpossiblemoves");
            }

        } catch (Exception e) {
        }

        return !getCapturePositions(getOppositePlayer()).contains(board.getPiecePosition(getCurrentKing()));
    }

    private King getCurrentKing() {
        if (getCurrentPlayer().getColor() == Color.WHITE) {
            return whiteKing;
        } else {
            return blackKing;
        }
    }

    private King getOppositeKing() {
        if (getCurrentPlayer().getColor() == Color.WHITE) {
            return blackKing;
        } else {
            return whiteKing;
        }
    }

    /**
     * Gets the list of positions where the player can capture the opponents
     * pieces
     *
     * @param player the current player
     * @return list of capture positions
     */
    private List<Position> getCapturePositions(Player player) {
        List<Position> list_Positions_Occu = board.getPositionsOccupiedBy(player);
        List<Position> list_Capture_Positions = new ArrayList<>();
        for (int i = 0; i < list_Positions_Occu.size(); i++) {
            list_Capture_Positions.addAll(getPiece(list_Positions_Occu.get(i)).getCapturePositions(list_Positions_Occu.get(i), board));
        }
        return list_Capture_Positions;
    }
}

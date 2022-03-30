package g59939.chess.model;

/**
 *
 * @author HONOR
 */
public class Board {
    
    private Square allSquares[][];
    
    /**
     * this constructor creates a 2D Object.array(Board)
     * and initialize every square to null value (there is no piece).
     */
    public Board () {
        allSquares = new Square[8][8];
        for (int i = 0; i < allSquares.length; i++) {
            for (int j = 0; j < allSquares[i].length; j++) {
                allSquares[i][j] = new Square(null);
            }
        }
    }
}

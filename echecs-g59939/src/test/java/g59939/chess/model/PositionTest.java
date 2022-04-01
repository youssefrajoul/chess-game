package g59939.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g59939
 */
public class PositionTest {

    public PositionTest() {
    }

    @Test
    public void testNextPosNE() {
        System.out.println("NextPosNE");
        Position posDepart = new Position(2, 2);
        Position posArrive = posDepart.next(Direction.NE);
        Position result = new Position(3, 3);
        assertEquals(posArrive, result);
    }

    @Test
    public void testNextPosNW() {
        System.out.println("NextPosNW ");
        Position posDepart = new Position(2, 2);
        Position posArrive = posDepart.next(Direction.NW);
        Position result = new Position(3, 1);
        assertEquals(posArrive, result);
    }

    @Test
    public void testNextPosNord() {
        System.out.println("NextPosNord");
        Position posDepart = new Position(2, 2);
        Position posArrive = posDepart.next(Direction.N);
        Position result = new Position(3, 2);
        assertEquals(posArrive, result);
    }

    @Test
    public void testNextPosSE() {
        System.out.println("NextPosSE");
        Position posDepart = new Position(2, 2);
        Position posArrive = posDepart.next(Direction.SE);
        Position result = new Position(1, 3);
        assertEquals(posArrive, result);
    }

    @Test
    public void testNextPosSW() {
        System.out.println("NextPosSW");
        Position posDepart = new Position(2, 2);
        Position posArrive = posDepart.next(Direction.SW);
        Position result = new Position(1, 1);
        assertEquals(posArrive, result);
    }

    @Test
    public void testNextPosSud() {
        System.out.println("NextPosSud");
        Position posDepart = new Position(2, 2);
        Position posArrive = posDepart.next(Direction.S);
        Position result = new Position(1, 2);
        assertEquals(posArrive, result);
    }

    @Test
    public void testNextPosEst() {
        System.out.println("NextPosEst");
        Position posDepart = new Position(2, 2);
        Position posArrive = posDepart.next(Direction.E);
        Position result = new Position(2, 3);
        assertEquals(posArrive, result);
    }

    @Test
    public void testNextPosWEST() {
        System.out.println("NextPosWEST");
        Position posDepart = new Position(2, 2);
        Position posArrive = posDepart.next(Direction.W);
        Position result = new Position(2, 1);
        assertEquals(posArrive, result);
    }

    @Test
    public void testOutOfBoardWP() {
        System.out.println("Out Of Board. White Pawn test");
        Position posDepart = new Position(7, 1);
        Position posArrive = posDepart.next(Direction.N);
        Position result = new Position(7, 1);
        assertEquals(posArrive, result);
    }

    @Test
    public void testOutOfBoardBP() {
        System.out.println("Out Of Board. Black Pawn test");
        Position posDepart = new Position(0, 1);
        Position posArrive = posDepart.next(Direction.S);
        Position result = new Position(0, 1);
        assertEquals(posArrive, result);
    }

}

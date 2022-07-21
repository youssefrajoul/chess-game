package g59939.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author HONOR
 */
public class PositionTest {

    public PositionTest() {
    }

    /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNextNW() {
        System.out.println("nextNW");
        Direction dir = Direction.NW;
        Position instance = new Position(4, 4);
        Position expResult = new Position(5, 3);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextN() {
        System.out.println("nextN");
        Direction dir = Direction.N;
        Position instance = new Position(4, 4);
        Position expResult = new Position(5, 4);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextNE() {
        System.out.println("nextNE");
        Direction dir = Direction.NE;
        Position instance = new Position(4, 4);
        Position expResult = new Position(5, 5);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextW() {
        System.out.println("nextW");
        Direction dir = Direction.W;
        Position instance = new Position(4, 4);
        Position expResult = new Position(4, 3);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextE() {
        System.out.println("nextE");
        Direction dir = Direction.E;
        Position instance = new Position(4, 4);
        Position expResult = new Position(4, 5);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextSW() {
        System.out.println("nextSW");
        Direction dir = Direction.SW;
        Position instance = new Position(4, 4);
        Position expResult = new Position(3, 3);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextS() {
        System.out.println("nextS");
        Direction dir = Direction.S;
        Position instance = new Position(4, 4);
        Position expResult = new Position(3, 4);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }

    @Test
    public void testNextSE() {
        System.out.println("nextSE");
        Direction dir = Direction.SE;
        Position instance = new Position(4, 4);
        Position expResult = new Position(3, 5);
        Position result = instance.next(dir);
        assertEquals(expResult, result);
    }

}

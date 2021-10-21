package tothemoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static tothemoon.Direction.*;

class DirectionTest {

    @Test
    public void shouldReturnDirection() {
        Assertions.assertEquals(N, valueOf("N"));
        Assertions.assertEquals(S, valueOf("S"));
        Assertions.assertEquals(W, valueOf("W"));
        Assertions.assertEquals(E, valueOf("E"));
    }

    @Test
    public void shouldReturnEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> valueOf("NS"));
    }

    @Test
    public void shouldCalculateClockwise(){
        Assertions.assertEquals(E, N.clockwise());
        Assertions.assertEquals(N, W.clockwise());
        Assertions.assertEquals(W, S.clockwise());
        Assertions.assertEquals(S, E.clockwise());
    }

    @Test
    public void shouldCalculateCounterClockwise(){
        Assertions.assertEquals(W, N.counterClockwise());
        Assertions.assertEquals(S, W.counterClockwise());
        Assertions.assertEquals(E, S.counterClockwise());
        Assertions.assertEquals(N, E.counterClockwise());
    }
}
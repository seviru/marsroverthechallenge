package tothemoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    public void checkPositions() {
        double expectedX = 1.0;
        double expectedY = 2.0;
        Position position = new Position(expectedX, expectedY);

        double returnedX = position.getPositionX();
        assertEquals(returnedX, expectedX);

        double returnedY = position.getPositionY();
        assertEquals(returnedY, expectedY);

        double[] returnedPosition = position.getPosition();
        assertArrayEquals(returnedPosition, new double[]{expectedX, expectedY});
    }
}
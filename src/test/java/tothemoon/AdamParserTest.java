package tothemoon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AdamParserTest {

    private static Stream<Arguments> getWrongInputs() {
        return Stream.of(
                Arguments.of(-10.0, 0.0, "N", 5.0, 5.0),
                Arguments.of(0.0, -6.0, "S", 5.0, 5.0),
                Arguments.of(10.0, 0.0, "W", 5.0, 5.0),
                Arguments.of(0.0, 6.0, "E", 5.0, 5.0),
                Arguments.of(0.0, 0.0, "NW", 5.0, 5.0),
                Arguments.of(0.0, 0.0, "C", 5.0, 5.0)
        );
    }

    @ParameterizedTest
    @MethodSource("getWrongInputs")
    public void checkGeneration(double posX, double posY, String direction, double mapX, double mapY) {
        assertThrows(IllegalArgumentException.class, () -> AdamParser.parseAdam(posX, posY, direction, mapX, mapY));
    }

    @Test
    public void shouldReturnAdamTestWhenIsOk() {
        Adam expected = new Adam(new Position(1.0, 2.0), Direction.N, new Position(2, 2));

        Adam actual = AdamParser.parseAdam(1.0, 2.0, "N", 2.0, 2.0);

        assertEquals(expected, actual);
    }
}

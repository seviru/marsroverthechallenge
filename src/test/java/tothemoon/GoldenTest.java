package tothemoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GoldenTest {

    private static Stream<Arguments> goldenParameters() {
        return Stream.of(
                Arguments.of("5 5\n1 2 N\nLMLMLMLMM", 1.0, 3.0, "N", 5.0, 5.0),
                Arguments.of("5 5\n3 3 E\nMMRMMRMRRM", 5.0, 1.0, "E", 5.0, 5.0)
        );
    }

    @ParameterizedTest
    @MethodSource("goldenParameters")
    void realGoldenTest(String generatorString, double posX, double posY, String direction, double mapX, double mapY) {

        Adam adam = AdamParser.parseAdamWithInstructions(generatorString);

        adam.executeInstructions();

        Adam expected = AdamParser.parseAdam(posX, posY, direction, mapX, mapY);

        Assertions.assertEquals(expected, adam);

    }
}

package tothemoon;

import java.util.List;

import static java.lang.Double.parseDouble;

public class AdamParser {

    public static Adam parseAdam(double x, double y, String direction, double mapX, double mapY) {
        double minX = 0.0;
        double minY = 0.0;

        checkPositions(x, y, minX, mapX, minY, mapY);
        checkDirection(direction);

        return new Adam(new Position(x, y), Direction.valueOf(direction), new Position(mapX, mapY));
    }

    private static void checkPositions(double x, double y, double minX, double maxX, double minY, double maxY) {
        if (!((x >= minX) && (x <= maxX) && (y >= minY) && (y <= maxY))) {
            throw new IllegalArgumentException("The map coordinates must be between" + minX + "and" + maxX + "for X axis, and between" + minY + "and" + maxY + " for Y axis.");
        }
    }

    private static void checkDirection(String direction) {
        Direction direction1 = Direction.valueOf(direction);
    }

    public static Adam parseAdamWithInstructions(String input) {
        List<Instruction> instructions = Instruction.parseInstructions(input.split("\n")[2]);

        String[] map = input.split("\n")[0].split(" ");
        String[] adamPosition = input.split("\n")[1].split(" ");

        return parseAdam(
                parseDouble(adamPosition[0]),
                parseDouble(adamPosition[1]),
                adamPosition[2],
                parseDouble(map[0]),
                parseDouble(map[1]))
                .withInstructions(instructions);
    }
}

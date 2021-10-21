package tothemoon;

import java.util.List;
import java.util.Objects;

public class Adam {
    private Position position;
    private Direction direction;
    private final Position mapLimits;
    private List<Instruction> instructions;

    public Adam(Position position, Direction direction, Position mapLimits) {
        this.position = position;
        this.direction = direction;
        this.mapLimits = mapLimits;
    }

    public void executeRoute(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            executeInstruction(instruction);
        }
    }

    private void executeInstruction(Instruction instruction) {
        switch (instruction) {
            case M:
                move();
                break;
            case R:
                this.direction = direction.clockwise();
                break;
            case L:
                this.direction = direction.counterClockwise();
                break;
        }
    }

    private void move() {
        switch (direction){
            case N:
                this.position = position.increaseY(mapLimits);
                break;
            case E:
                this.position = position.increaseX(mapLimits);
                break;
            case S:
                this.position = position.decreaseY(mapLimits);
                break;
            case W:
                this.position = position.decreaseX(mapLimits);
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adam adam = (Adam) o;
        return Objects.equals(position, adam.position) && Objects.equals(direction, adam.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "Adam{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }

    public Adam withInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
        return this;
    }

    public void executeInstructions() {
        executeRoute(this.instructions);
    }
}

package tothemoon;

import java.util.Objects;

public class Position {
    private final double X;
    private final double Y;

    public Position(double posX, double posY) {
        this.X = posX;
        this.Y = posY;
    }

    public double getPositionX() {
        return this.X;
    }

    public double getPositionY() {
        return this.Y;

    }

    public double[] getPosition() {
        return new double[]{this.X, this.Y};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Double.compare(position.X, X) == 0 && Double.compare(position.Y, Y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    public Position increaseY(Position limit) {
        double posY = Y + 1;
        if (posY > limit.Y) {
            return new Position(X, 0);
        }
        return new Position(X, posY);
    }

    public Position increaseX(Position limit){
        double posX = X + 1;
        if (posX > limit.X){
            return new Position(0, Y);
        }
        return new Position(posX, Y);

    }

    public Position decreaseY(Position limit){
        double posY = Y - 1;
        if (posY < 0){
            return new Position(X, limit.Y);
        }
        return new Position(X, posY);
    }

    public Position decreaseX(Position limit){
        double posX = X - 1;
        if (posX < 0){
            return new Position(limit.X, Y);
        }
        return new Position(posX, Y);
    }
    @Override
    public String toString() {
        return  X + "," + Y;
    }
}

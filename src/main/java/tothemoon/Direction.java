package tothemoon;

public enum Direction {
    N, E, S, W;
    private Direction clockwise;
    private Direction counterClockwise;

    static {
        N.clockwise = E;
        N.counterClockwise = W;
        E.clockwise = S;
        E.counterClockwise = N;
        S.clockwise = W;
        S.counterClockwise = E;
        W.clockwise = N;
        W.counterClockwise = S;
    }

    public Direction clockwise() {
        return clockwise;
    }

    public Direction counterClockwise(){
        return counterClockwise;
    }
}

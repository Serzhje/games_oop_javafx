package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = 7;
        Cell[] steps = new Cell[size];
        int deltaX = position().getX();
        int deltaY = position().getY();
        for (int i = 0; i < size; i++) {
            if (deltaX < dest.getX() && deltaY > dest.getY()) {
                deltaX++;
                deltaY--;
            } else if (deltaX < dest.getX() && deltaY < dest.getY()) {
                deltaX++;
                deltaY++;
            } else if (deltaX > dest.getX() && deltaY < dest.getY()) {
                deltaX--;
                deltaY++;
            } else if (deltaX > dest.getX() && deltaY > dest.getY()) {
                deltaX--;
                deltaY--;
            } else if (deltaX == dest.getX() && deltaY == dest.getY()) {
                steps[i] = Cell.findBy(deltaX, deltaY);
                break;
            }
            steps[i] = Cell.findBy(deltaX, deltaY);
        }
        return Arrays.copyOf(steps, Math.abs(position().getX() - dest.getX()));
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(source.getX() - dest.getX())
                == Math.abs(source.getY() - dest.getY())) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

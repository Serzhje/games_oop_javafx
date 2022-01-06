package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionEquals() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell actuals = bishopBlack.position();
        Cell expected = Cell.C8;
        assertEquals(expected, actuals);
    }

    @Test
    public void whenCopyEquals() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Figure actuals =  bishopBlack.copy(Cell.D6);
        Cell expected = Cell.D6;
        assertEquals(expected, actuals.position());
    }

    @Test
    public void whenWayC1toG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell []actuals = bishopBlack.way(Cell.G5);
        Cell []expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, actuals);
    }

    @Test
    public void whenWayA1toH8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell []actuals = bishopBlack.way(Cell.H8);
        Cell []expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertArrayEquals(expected, actuals);
    }

    @Test
    public void whenIsNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        boolean actuals = bishopBlack.isDiagonal(bishopBlack.position(), Cell.H7);
        assertFalse(actuals);
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        boolean actuals = bishopBlack.isDiagonal(bishopBlack.position(), Cell.H8);
        assertTrue(actuals);
    }

}
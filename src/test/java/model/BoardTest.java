package model;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {


    @Test
    public void isWonDiagonalTest() {
        Board b = new Board();

        b.setMove(0, 0); // X
        b.setMove(1, 2);
        b.setMove(1, 1); // X
        b.setMove(2, 1);
        b.setMove(2, 2); // X

        System.out.println(b.toString());
        Assert.assertEquals(false, b.isWon(Board.PLAYER_O));
        Assert.assertEquals(true, b.isWon(Board.PLAYER_X));
    }

    @Test
    public void playerTurnTest() {
        Board b = new Board();

        Assert.assertEquals(Board.PLAYER_X, b.getPlayer());
        b.setMove(0, 0);
        Assert.assertEquals(Board.PLAYER_O, b.getPlayer());
    }
}
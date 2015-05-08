package ticTacToe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import ticTacToe.TicTacToe.Board;

/**
 * Created by jfortier
 */
public class WinTest extends BoardTest {
    private static final char[][] ROW_WIN = {{'X','X','X'},{'_','O','_'},{'_','O','O'}};
    private static final char[][] CATS_GAME = {{'X','X','O'},{'O','O','X'},{'X','O','X'}};
    private static final char[] CATS_GAME_FLAT = {'X','X','O','O','O','X','X','O','X'};

    @After
    public void additionalTearDown() {
        System.out.println(b.currentBoard());
    }

    @Test
    public void emptyBoardsHaveNoWinner() throws Exception {
        assertFalse("A fresh board should not have a winner.", b.hasWin());
    }

    @Test
    public void rowWinsAreDetected() throws Exception {
        b = new Board(ROW_WIN);
        assertTrue("Row win was not detected.", b.hasWin());
    }

    @Test
    public void colWinsAreDetected() throws Exception {
        b.makeMove('O',1);
        b.makeMove('O',4);
        b.makeMove('O',7);
        assertTrue("Col win was not detected.", b.hasWin());
    }

    @Test
    public void backwardWinsAreDetected() throws Exception {
        b.makeMove('X',1);
        b.makeMove('X',5);
        b.makeMove('X',9);
        assertTrue("Backward diagonal win was not detected.", b.hasWin());
    }

    @Test
    public void forwardWinsAreDetected() throws Exception {
        b.makeMove('O',3);
        b.makeMove('O',5);
        b.makeMove('O',7);
        assertTrue("Forward diagonal win was not detected.", b.hasWin());
    }

    @Test
    public void mixedPlayerWinPatternsDontWin() throws Exception {
        b.makeMove('O',3);
        b.makeMove('X',5);
        b.makeMove('O',7);
        assertFalse("Mixed-player forward diagonal should not be a win.", b.hasWin());
    }

    @Test
    @Ignore("TTT-54")
    public void gameIsOverWithFullBoardNoWin() throws Exception {
        b = new Board(CATS_GAME);
        assertTrue("Game should end when players tie.", b.isOver());

    }

    @Test
    public void gameIsOverWithMaxPlaysNoWin() throws Exception {
        for (int p = 0; p < 9; p++) b.makeMove(CATS_GAME_FLAT[p],p+1);
        assertTrue("Game should end when players tie.",b.isOver());
    }

    @Test
    public void gameIsOverWithMinPlaysAndWin() throws Exception {
        for (int p = 1; p <= 3; p++) b.makeMove('X',p);
        assertTrue("Game should end when a player wins.",b.isOver());
    }
}

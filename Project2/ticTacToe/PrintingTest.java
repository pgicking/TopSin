package ticTacToe_solution.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by jfortier
 */
public class PrintingTest extends BoardTest {
    private static final String blank_board =
            " ___ ___ ___ \n" +
            "|___|___|___|\n" +
            "|___|___|___|\n" +
            "|___|___|___|\n";

    private static final String board5x =
            " ___ ___ ___ \n" +
            "|___|___|___|\n" +
            "|___|_X_|___|\n" +
            "|___|___|___|\n";

    private static final String boardAllO =
            " ___ ___ ___ \n" +
            "|_O_|_O_|_O_|\n" +
            "|_O_|_O_|_O_|\n" +
            "|_O_|_O_|_O_|\n";

    @Test
    @Ignore("TTT-52")
    public void freshlyInitializedBoardPrintsCorrectly() throws Exception {
        String freshBoard = b.currentBoard();
        assertEquals("Expected:\n"+blank_board+"\n but instead got:\n"+freshBoard,
                blank_board, freshBoard);
    }

    @Test
    @Ignore("TTT-52")
    public void currentBoardDisplaysTheLatestBoardState() throws Exception {
        b.makeMove('X',5);
        String updatedBoard = b.currentBoard();
        assertEquals("Expected:\n"+board5x+"\n but instead got:\n"+updatedBoard,
                board5x, updatedBoard);
    }

    @Test
    @Ignore("TTT-52")
    public void postWinBoardStillPrints() throws Exception {
        for (int p = 1; p <= 9; p++) b.makeMove('O',p); // fill all board positions
        String endGameBoard = b.currentBoard();
        assertEquals("Expected:\n"+boardAllO+"\n but instead got:\n"+endGameBoard,
                boardAllO, endGameBoard);
    }
}

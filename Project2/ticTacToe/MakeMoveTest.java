package ticTacToe_solution.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by jfortier
 */
public class MakeMoveTest extends BoardTest {

    @Test
    public void firstValidPositionIsPlacedCorrectly() throws Exception {
        b.makeMove('X',1);
        assertTrue("Expected a character in position 1 but instead received:\n"+b.currentBoard(),
                arraysEqual(board1x,b.getBoard()));
    }

    @Test
    public void lastValidPositionIsPlacedCorrectly() throws Exception {
        b.makeMove('O', 9);
        assertTrue("Expected a character in position 1 but instead received:\n"+b.currentBoard(),
                arraysEqual(board9o,b.getBoard()));
    }

    @Test
    @Ignore("TTT-51")
    public void invalidNegativePositionGivesInvalidMoveError() throws Exception {
        try {
            b.makeMove('X', -1);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That move is invalid."));
            return;
        } catch (Throwable t) {
            fail("Encountered unexpected exception: " + t);
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }

    @Test
    @Ignore("TTT-51")
    public void invalidZeroPositionGivesInvalidMoveError() throws Exception {
        try {
            b.makeMove('X', 0);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That move is invalid."));
            return;
        } catch (Throwable t) {
            fail("Encountered unexpected exception: " + t);
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }

    @Test
    @Ignore("TTT-51")
    public void invalidPositivePositionGivesInvalidMoveError() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("That move is invalid.");
        b.makeMove('O', 10);
    }

    @Test
    public void invalidOccupiedPositionsGivesInvalidMoveError() throws Exception {
        b.makeMove('X',1);
        try {
            b.makeMove('O', 1);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That move is invalid."));
            return;
        } catch (Throwable t) {
            fail("Encountered unexpected exception: "+t);
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }

    @Test
    @Ignore("TTT-53")
    public void invalidPlayerTokenGivesError() throws Exception {
        try {
            b.makeMove('Z', 1);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Player token unrecognized."));
            return;
        } catch (Throwable t) {
            fail("Encountered unexpected exception: " + t);
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }
}

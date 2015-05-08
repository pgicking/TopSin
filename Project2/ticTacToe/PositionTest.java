package ticTacToe_solution.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by jfortier
 */
public class PositionTest extends BoardTest {

    @Test
    public void getRowOfValidPosition() throws Exception {
        int row = b.getRow(1);
        assertEquals("Expected row 0 but got "+row, 0, row);
    }

    @Test
    @Ignore("TTT-51")
    public void getRowOfInvalidNegativePosition() throws Exception {
        try {
            b.getRow(-1);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That move is invalid."));
            return;
        } catch (Throwable t) {
            fail("Expected an IllegalArgumentException, but instead got: "+t);
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }

    @Test
    @Ignore("TTT-51")
    public void getRowOfInvalidZeroPosition() throws Exception {
        try {
            b.getRow(0);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That move is invalid."));
            return;
        } catch (Throwable t) {
            fail("Expected an IllegalArgumentException, but instead got: "+t);
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }

    @Test
    @Ignore("TTT-51")
    public void getRowOfInvalidPositivePosition() throws Exception {
        try {
            b.getRow(3);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That move is invalid."));
            return;
        } catch (Throwable t) {
            fail("Expected an IllegalArgumentException, but instead got: "+t);
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }

    @Test
    public void getColOfValidPosition() throws Exception {
        int row = b.getCol(9);
        assertEquals("Expected col 2 but got " + row, 2, row);
    }

    @Test
    @Ignore("TTT-51")
    public void getColOfInvalidNegativePosition() throws Exception {
        try {
            b.getCol(-1);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That move is invalid."));
            return;
        } catch (Throwable t) {
            fail("Expected an IllegalArgumentException, but instead got: " + t.getClass());
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }

    @Test
    @Ignore("TTT-51")
    public void getColOfInvalidZeroPosition() throws Exception {
        try {
            b.getCol(0);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That move is invalid."));
            return;
        } catch (Throwable t) {
            fail("Expected an IllegalArgumentException, but instead got: " + t.getClass());
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }

    @Test
    @Ignore("TTT-51")
    public void getColOfInvalidPositivePosition() throws Exception {
        try {
            b.getCol(3);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That move is invalid."));
            return;
        } catch (Throwable t) {
            fail("Expected an IllegalArgumentException, but instead got: "+t.getClass());
        }
        fail("Expected an IllegalArgumentException to be thrown.");
    }

}

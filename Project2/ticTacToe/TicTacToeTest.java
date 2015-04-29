package ticTacToe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.InvokeMethod;
import ticTacToe.TicTacToe;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class TicTacToeTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMain() throws Exception {
        TicTacToe.main(null);
    }

    @Test
    public void testOutOfBounds() throws Exception {

    }

    @Test
    public void testUpdateScoreBoard() throws Exception {


    }
}
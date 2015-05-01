package ticTacToe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.InvokeMethod;
import ticTacToe.TicTacToe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TicTacToeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();



    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setErr(null);

        System.setIn(System.in);
    }


    public void setInput(String s){

        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);

    }

    @Test
    public void testMain() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("y\n1\n0\n".getBytes());

        System.setIn(in);
        TicTacToe.main(null);

    }

    @Test
    public void testOutOfBounds() throws Exception {
        String s = "y\n1\n0\n";
        setInput(s);

    }

    @Test
    public void testUpdateScoreBoard() throws Exception {


    }
}
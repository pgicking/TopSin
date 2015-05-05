package ticTacToe;

import com.apple.eawt.AppEvent;
import org.junit.*;
import org.junit.internal.runners.statements.InvokeMethod;
import ticTacToe.TicTacToe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
        System.out.flush();
        System.err.flush();

        //System.setIn(System.in);
        //System.in.reset();
    }

    public void setInput(String s) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
        //System.setIn(System.in);
    }

    @Test
    public void testMain() throws Exception {
        String s = "n\n";
        setInput(s);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testOutOfBounds() throws Exception {
        String s = "y\n1\n0\n";
        setInput(s);

    }

    @Test
    public void testXWin() throws Exception {
        String s = "y\n1\n2\n4\n5\n7\nn\n";
        setInput(s);
        assertTrue(outContent.toString().contains("Player X wins!"));

    }

    @Test
    public void testUpdateScoreBoard() throws Exception {


    }
}
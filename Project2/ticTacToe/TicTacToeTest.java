package ticTacToe;

import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class TicTacToeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//    private ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());



    @Before
    public void setUp() throws Exception {
        //System.setOut(new PrintStream(outContent));
//        System.setErr(new PrintStream(errContent));
//        System.setIn(in);
    }

    @After
    public void tearDown() throws Exception {
        System.out.flush();
        System.err.flush();
        System.in.reset();
        //System.setIn(System.in);
        //System.in.reset();

    }

    public void setInput(String s) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
        //in.reset();
        //System.setIn(System.in);
        //System.setIn(null);
    }

    @Test
    public void testMain() throws Exception {
        String s = "n\n";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
//        setInput(s);
    }


    @Test
    public void testXWin() throws Exception {
        String s = "y\n1\n2\n4\n5\n7\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
//        setInput(s);
        assertTrue(outContent.toString().contains("Player X wins!"));

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testOutOfBounds() throws Exception {
        String s = "y\n1\n0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
//        setInput(s);
//        in.reset();

    }

    @Test
    public void testUpdateScoreBoard() throws Exception {


    }

    @Test
    public void testOWin() throws Exception {
        String s = "y\n2\n1\n5\n4\n6\n7\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
//        setInput(s);
        assertTrue(outContent.toString().contains("Player O wins!"));
    }

    @Test(expected = NumberFormatException.class)
    public void testNumberFormatException() throws Exception {
        String s = "y\ng\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
//        setInput(s);
        assertTrue(outContent.toString().contains("That input wasn't recognized."));

    }

    @Test
    public void testInputNotRecognized() throws Exception {
        String s = "g\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
//        setInput(s);
        assertTrue(outContent.toString().contains("That input wasn't recognized."));
    }

    @Test
    public void testInvalidInput() throws Exception {
        String s = "y\n1\n1\n2\n4\n5\n7\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
//        setInput(s);
        assertTrue(outContent.toString().contains("Whoops! That's not a valid move!"));

    }

    @Test
    public void testTieGame() throws Exception {
        String s = "y\n5\n1\n2\n8\n9\n6\n3\n7\n4\nn";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);
//        setInput(s);
        assertTrue(outContent.toString().contains("Tie!"));

    }

    @Ignore //takes waaaaay too long
    public void testOverflow() throws Exception {
        String s = null;
        for(int i = 0; i < Integer.MAX_VALUE; ++i){
            s += "y\n1\n2\n4\n5\n7";
        }
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        TicTacToe.main(null);

    }
}
package ticTacToe;

import static org.hamcrest.Matchers.is;

import org.junit.*;
import org.junit.rules.ExpectedException;

import ticTacToe.TicTacToe.Board;

public class BoardTest {
    protected static final char[][] sample = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    protected static final char[][] blank_board = {{'_','_','_'},{'_','_','_'},{'_','_','_'}};
    protected static final char[][] board1x = {{'X','_','_'},{'_','_','_'},{'_','_','_'}};
    protected static final char[][] board9o = {{'_','_','_'},{'_','_','_'},{'_','_','O'}};
    protected Board b;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Perform any necessary one-time environment prep.
     */
    @BeforeClass
    public static void readyFramework() {
        System.out.println("BEGIN TESTING NOW.");
    }

    /**
     * Perform any one-time environment closures.
     */
    @AfterClass
    public static void closeFramework() {
        System.out.println("TESTING OVER.");
    }


    /**
     * Before each test, create a new Board with the default
     * (blank) board configuration
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        System.out.print("\tTest has begun... ");
        b = new Board();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test complete.");
    }

    /**
     * Determines whether two two-dimensional char arrays
     * are equal in size and in contents.
     * @param expected
     * @param actual
     * @return
     */
    protected boolean arraysEqual(char[][] expected, char[][] actual) {
        if (expected.length != actual.length) return false;
        for (int i = 0; i < expected.length; i++) {
            if (expected[i].length != actual[i].length) return false;
            for (int j = 0; j < expected[i].length; j++) {
                if (expected[i][j] != actual[i][j]) return false;
            }
        }
        return true;
    }

}
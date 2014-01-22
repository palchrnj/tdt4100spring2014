package objectstructures_old;

import no.hal.jex.runtime.JExercise;
import no.hal.jex.standalone.JexStandalone;
import junit.framework.TestCase;

@JExercise(
	description="A TicTacToe class must hold all logic necessary for playing Tic-Tac-Toe game."
)
public class TicTacToeTestPart1 extends TestCase {

	TicTacToe ttt;

	protected void setUp() throws Exception {
		super.setUp();
		ttt = new TicTacToe();
	}
	
	@JExercise(
			tests="int getStringIndexForCoordinates(int, int)",
			description="The getStringIndexForCoordinates(int, int) method should return the appropriate String index position per x and y coordinates. x,y=(0,0) --> index=0, x,y=(1,0) --> index=1, ..., x,y=(2,2) --> index=8."
		)
		public void testGetStringIndexForCoordinates() {
			// Row 1
			assertEquals(0, ttt.getStringIndexForCoordinates(0, 0));
			assertEquals(1, ttt.getStringIndexForCoordinates(1, 0));
			assertEquals(2, ttt.getStringIndexForCoordinates(2, 0));
			
			// Row 2
			assertEquals(3, ttt.getStringIndexForCoordinates(0, 1));
			assertEquals(4, ttt.getStringIndexForCoordinates(1, 1));
			assertEquals(5, ttt.getStringIndexForCoordinates(2, 1));
			
			// Row 3
			assertEquals(6, ttt.getStringIndexForCoordinates(0, 2));
			assertEquals(7, ttt.getStringIndexForCoordinates(1, 2));
			assertEquals(8, ttt.getStringIndexForCoordinates(2, 2));
		}

	@JExercise(
		tests="boolean makePlacement(String, int, int)",
		description="The makePlacement(String, int, int) takes a String argument and sets the appropriate position (based on the ints corresponding to x and y) in the gridString equal to the argument. If the placement is successfully made the method should return true. Otherwise false."
	)
	public void testMakePlacement() {
		// Illegal player
		ttt.makePlacement("Y", 0, 0);
		assertEquals(' ', ttt.gridString.charAt(0));
		
		// Regular placements
		ttt.makePlacement("X", 0, 0);
		assertEquals('X', ttt.gridString.charAt(0));
		ttt.makePlacement("O", 1, 0);
		assertEquals('O', ttt.gridString.charAt(1));
		ttt.makePlacement("O", 0, 1);
		assertEquals('O', ttt.gridString.charAt(3));
		ttt.makePlacement("X", 2, 1);
		assertEquals('X', ttt.gridString.charAt(5));
		ttt.makePlacement("X", 1, 2);
		assertEquals('X', ttt.gridString.charAt(7));
		
		// Should not be possible to overwrite
		ttt.makePlacement("O", 0, 0);
		assertEquals('X', ttt.gridString.charAt(0));
		
		// Illegal position
		assertFalse(ttt.makePlacement("O", 3, 3));
		
	}
	
	@JExercise(
			tests="String hasWon()",
			description="The hasWon() checks whether one of the players (\"X\" or \"O\") has won the game. This test verifies that three equal in a row results in a win."
	)
	public void testHasWonRow() {
		assertEquals(null, ttt.hasWon());
		// Three in a row
		for (int row = 0; row <= 2; row++) {
			ttt.makePlacement("X", 0, row);
			assertEquals(null, ttt.hasWon());
			ttt.makePlacement("X", 1, row);
			assertEquals(null, ttt.hasWon());
			ttt.makePlacement("X", 2, row);
			assertEquals("X", ttt.hasWon());
			ttt = new TicTacToe();
		}
	}
	
	@JExercise(
			tests="String hasWon()",
			description="The hasWon() checks whether one of the players (\"X\" or \"O\") has won the game. This test verifies that three equal in a column results in a win."
	)
	public void testHasWonColumn() {
		// Three in a column
		for (int col = 0; col <= 2; col++) {
			ttt.makePlacement("O", col, 0);
			assertEquals(null, ttt.hasWon());
			ttt.makePlacement("O", col, 1);
			assertEquals(null, ttt.hasWon());
			ttt.makePlacement("O", col, 2);
			assertEquals("O", ttt.hasWon());
			ttt = new TicTacToe();
		}
	}
	
	@JExercise(
			tests="String hasWon()",
			description="The hasWon() checks whether one of the players (\"X\" or \"O\") has won the game. This test verifies that three equal across results in a win."
	)
	public void testHasWonAcross() {
		// Three across (NW - SE)
		ttt.makePlacement("X", 0, 0);
		assertEquals(null, ttt.hasWon());
		ttt.makePlacement("X", 1, 1);
		assertEquals(null, ttt.hasWon());
		ttt.makePlacement("X", 2, 2);
		assertEquals("X", ttt.hasWon());
		ttt = new TicTacToe();

		// Three across (NE - SW)
		ttt.makePlacement("O", 2, 0);
		assertEquals(null, ttt.hasWon());
		ttt.makePlacement("O", 1, 1);
		assertEquals(null, ttt.hasWon());
		ttt.makePlacement("O", 0, 2);
		assertEquals("O", ttt.hasWon());
	}
	
	@JExercise(
			tests="String hasWon()",
			description="The hasWon() checks whether one of the players (\"X\" or \"O\") has won the game. This test verifies that a full board with no winner results in draw."
	)
	public void testHasWonDraw() {
		// Draw
		ttt.makePlacement("X", 0, 0);
		ttt.makePlacement("O", 1, 0);
		ttt.makePlacement("X", 2, 0);

		ttt.makePlacement("O", 0, 1);
		ttt.makePlacement("X", 1, 1);
		ttt.makePlacement("X", 2, 1);

		ttt.makePlacement("O", 0, 2);
		ttt.makePlacement("X", 1, 2);
		ttt.makePlacement("O", 2, 2);
		assertEquals("draw", ttt.hasWon());
	}
	
	@JExercise(
			tests="String changePlayer(String)",
			description="The changePlayer(String) method changes the active player (from \"X\" to \"O\", and vice versa)."
	)
	public void testChangePlayer() {
		assertEquals("X", ttt.changePlayer("O"));
		assertEquals("O", ttt.changePlayer("X"));
	}
	
	public static void main(String[] args) {
		JexStandalone.main(TicTacToeTest.class);
	}
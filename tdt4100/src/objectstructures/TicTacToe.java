package objectstructures;

import java.util.Scanner;

public class TicTacToe {
	
	// empty board position = " "
	// player X = "X"
	// player O = "O"
	public String gridString;
	
	public TicTacToe() {
		gridString = "         ";
	}
	
	public boolean makePlacement(String player, int x, int y) {
		if (0 <= x && x <= 2 && 0 <= y && y <= y) {
			int stringIndex = getStringIndexForCoordinates(x, y);
			String stringAtIndex = "" + gridString.charAt(stringIndex);
			if (stringAtIndex.equals("X") || stringAtIndex.equals("O")) {
				return false;
			} else if (stringAtIndex.equals(" ") && (player.equals("X") || player.equals("O")) ) {
				gridString = gridString.substring(0, stringIndex) + player + gridString.substring(stringIndex+1);
				return true;
			} else {
				// Invalid String
				return false;
			}
		} else {
			// Invalid index
			return false;			
		}
	}
	
	/* 
	 * Grid coordinates:
	 * (0,0) | (1,0) | (2,0)
	 * ---------------------
	 * (0,1) | (1,1) | (2,1)
	 * ---------------------
	 * (0,2) | (1,2) | (2,2)
	 */
	public int getStringIndexForCoordinates(int x, int y) {
		return x + 3 * y;
		
	}
	
	public String hasWon() {
		// Three in a row
		String row1 = gridString.substring(0, 3);
		String row2 = gridString.substring(3, 6);
		String row3 = gridString.substring(6, 9);
		if (row1.contains("XXX") || row2.contains("XXX") || row3.contains("XXX")) {
			return "X";
		} else if (row1.contains("OOO") || row2.contains("OOO") || row3.contains("OOO")) {
			return "O";
		}
		
		// Three in a column
		String col1 = "" + gridString.charAt(0) + gridString.charAt(3) + gridString.charAt(6);
		String col2 = "" + gridString.charAt(1) + gridString.charAt(4) + gridString.charAt(7);
		String col3 = "" + gridString.charAt(2) + gridString.charAt(5) + gridString.charAt(8);
		if (col1.contains("XXX") || col2.contains("XXX") || col3.contains("XXX")) {
			return "X";
		} else if (col1.contains("OOO") || col2.contains("OOO") || col3.contains("OOO")) {
			return "O";
		}
		
		// Three across
		String across1 = "" + gridString.charAt(0) + gridString.charAt(4) + gridString.charAt(8);
		String across2 = "" + gridString.charAt(2) + gridString.charAt(4) + gridString.charAt(6);
		if (across1.contains("XXX") || across2.contains("XXX")) {
			return "X";
		} else if (across1.contains("OOO") || across2.contains("OOO")) {
			return "O";
		}
		// Draw
		for (int i = 0; i < gridString.length(); i++) {
			if (gridString.charAt(i) == ' ') {
				return null;
			}
		}
		return "draw";
	}
	
	public String toString() {
		String str = "";
		for (int y = 0; y <= 2; y++) {
			for (int x = 0; x <= 2; x++) {
				str += " " + gridString.charAt(getStringIndexForCoordinates(x, y)) + " |";
			}
			str = str.substring(0,str.length()-2) + "\n-----------\n";
		}
		return str.substring(0, str.length()-12);
	}
	
	public String changePlayer(String player) {
		if (player.equals("X")) {
			return "O";
		} else {
			return "X";
		}
	}
	
	public int getXForInput(String input) {
		if ("qaz".contains(input)) {
			return 0;
		} else if ("wsx".contains(input)) {
			return 1;
		} else if ("edc".contains(input)) {
			return 2;
		} else {
			return -1;
		}
	}

	public int getYForInput(String input) {
		if ("qwe".contains(input)) {
			return 0;
		} else if ("asd".contains(input)) {
			return 1;
		} else if ("zxc".contains(input)) {
			return 2;
		} else {
			return -1;
		}
	}
	
	public void printInstructions() {
		String str = "Use keys corresponding to board positions:\n q | w | e \n-----------\n a | s | d \n-----------\n z | x | c \n###########\n";
		System.out.println(str);
	}
	
	public boolean play() {
		Scanner scr = new Scanner(System.in);
		String player = "X";
		printInstructions();
		while (hasWon() == null) {
			// Read input from user
			System.out.println(this);
			System.out.println("Player " + player + " make a move:");
			String input = "" + scr.next().charAt(0);
			int x = getXForInput(input);
			int y = getYForInput(input);
			boolean validPlacement = makePlacement(player, x, y);
			if (validPlacement && x != -1 && y != -1) {
				player = changePlayer(player);
			}
			// Check win condition
			String hasWonString = hasWon(); 
			if (hasWonString == "X" || hasWonString == "Y" ) {
				System.out.println(this);
				System.out.println("Player " + hasWonString + " has won the game.");
			} 
			if (hasWonString == "draw") {
				System.out.println("The game ended in a draw.");
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		ttt.play();
	}
}
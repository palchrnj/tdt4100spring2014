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
		if (gridString.contains("XXX")) {
			return "X";
		} else if (gridString.contains("OOO")) {
			return "O";
		}
		
		// Three in a column
		String str = "" + gridString.charAt(0) + gridString.charAt(3) + gridString.charAt(6) + 
				gridString.charAt(1) + gridString.charAt(4) + gridString.charAt(7) + 
				gridString.charAt(2) + gridString.charAt(5) + gridString.charAt(8);
		if (str.contains("XXX")) {
			return "X";
		} else if (str.contains("OOO")) {
			return "O";
		}
		
		// Three across
		str = "" + gridString.charAt(0) + gridString.charAt(4) + gridString.charAt(8) + 
				gridString.charAt(2) + gridString.charAt(4) + gridString.charAt(6);
		if (str.contains("XXX")) {
			return "X";
		} else if (str.contains("OOO")) {
			return "O";
		}
		return null;
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
			if (hasWonString != null) {
				System.out.println(this);
				System.out.println("Player " + hasWonString + " has won the game.");
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		ttt.play();
	}
}
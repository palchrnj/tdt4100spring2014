package objectstructures;

import java.util.Scanner;

public class TicTacToe {
	
	/*
	 * PART 1
	 */
	
	public String gridString;
	public char player;
	
	public TicTacToe() {
		gridString = "         ";
		player = 'x';
	}
	
	public char getCell(int x, int y) {
		return gridString.charAt(indexAt(x, y));
	}
	
	public boolean isOccupied(int x, int y) {
		return getCell(x, y) != ' ';
	}
	public boolean setCell(char c, int x, int y) {
		if (! isOccupied(x, y)) {
			int index = indexAt(x, y);
			gridString = gridString.substring(0, index) + c + gridString.substring(index+1);
			return true;
		}
		return false;
	}
	public String toString() {
		String str = "";
		for (int y = 0; y <= 2; y++) {
			for (int x = 0; x <= 2; x++) {
				str += " " + gridString.charAt(indexAt(x, y)) + " |";
			}
			str = str.substring(0,str.length()-2) + "\n-----------\n";
		}
		return str.substring(0, str.length()-12);
	}
	
	/* 
	 * Grid coordinates:
	 * (0,0) | (1,0) | (2,0)
	 * ---------------------
	 * (0,1) | (1,1) | (2,1)
	 * ---------------------
	 * (0,2) | (1,2) | (2,2)
	 */
	public int indexAt(int x, int y) {
		return x + 3 * y;
	}

	/*
	 * PART 2
	 */
	
	public boolean isFinished() {
		if (hasWinner()) {
			return true;
		} else {
			// If there is no winner and there are unoccupied positions on the board we're still not finished
			for (int i = 0; i < gridString.length(); i++) {
				if (gridString.charAt(i) == ' ') {
					return false;
				}
			}
			// Draw
			return true;
		}
	}
	public boolean isWinner(char c) {
		String win = "" + c + c +c;
		// Three in a row
		String row1 = gridString.substring(0, 3);
		String row2 = gridString.substring(3, 6);
		String row3 = gridString.substring(6, 9);
		if (row1.contains(win) || row2.contains(win) || row3.contains(win)) {
			return true;
		}
		// Three in a column
		String col1 = "" + gridString.charAt(0) + gridString.charAt(3) + gridString.charAt(6);
		String col2 = "" + gridString.charAt(1) + gridString.charAt(4) + gridString.charAt(7);
		String col3 = "" + gridString.charAt(2) + gridString.charAt(5) + gridString.charAt(8);
		if (col1.contains(win) || col2.contains(win) || col3.contains(win)) {
			return true;
		}
		// Three across
		String across1 = "" + gridString.charAt(0) + gridString.charAt(4) + gridString.charAt(8);
		String across2 = "" + gridString.charAt(2) + gridString.charAt(4) + gridString.charAt(6);
		if (across1.contains(win) || across2.contains(win)) {
			return true;
		}
		return false;
	}
		
	public boolean hasWinner() {
		return isWinner('x') || isWinner('o');
	}
	public void play(int x, int y) {
		if (setCell(player, x, y)) {
			// Change player
			player = player == 'x' ? 'o' : 'x';
		}
	}
	
	/*
	 * PART 3
	 */
	
	public void printInstructions() {
		String str = "Enter x and y coordinate of next placement (separated by whitespace) corresponding to board positions:\n 0 0 | 1 0 | 2 0 \n-----------------\n 0 1 | 1 1 | 2 1 \n-----------------\n 0 2 | 1 2 | 2 2 \n###########\n";
		System.out.println(str);
	}
		
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		Scanner scr = new Scanner(System.in);
		ttt.printInstructions();
		while (! ttt.isFinished()) {
			System.out.println(ttt);
			System.out.println("Player " + ttt.player + ", enter position of desired move:");
			int x = scr.nextInt();
			int y = scr.nextInt();
			ttt.play(x, y);
		}
		System.out.println(ttt);
		if (! ttt.hasWinner()) {
			// The game ended in a draw
			System.out.println("The game ended in a draw.");
		} else if (ttt.isWinner('x')) {
			System.out.println("Player x has won the game.");
		} else if (ttt.isWinner('o')) {
			System.out.println("Player o has won the game.");
		} 
	}
}
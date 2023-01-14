package cpsc2150.connectX;

import java.util.Scanner;

public class Connect4Game {
	public static void main(String[] args) {
		GameBoard board = new GameBoard();
		Scanner scan = new Scanner(System.in);
		char choice = 'Y', player = 'X';
		int insertCol = -1;

		System.out.println(board.toString());

		// main loop, keep the game going till the user answers N/n
		do {
			// loop to obtain column value, ensures 0 < insertCol < MAX_COLUMN and checkIfFree == true
			do {
				System.out.println("Player " + player + ", what column do you want to place your marker in?");
				insertCol = scan.nextInt();
				if (insertCol < 0)
					System.out.println("Column cannot be less than 0");
				else if (insertCol >= GameBoard.MAX_COLUMN)
					System.out.println("Column cannot be greater than " + (GameBoard.MAX_COLUMN - 1));
				else if (!board.checkIfFree(insertCol))
					System.out.println("Column is full");
			} while (insertCol < 0 || insertCol >= GameBoard.MAX_COLUMN || !board.checkIfFree(insertCol));

			board.placeToken(player, insertCol);
			System.out.println(board.toString());

			// checks for a win/tie
			if (board.checkForWin(insertCol)) {
				System.out.println("Player " + player + " Won!");
			} else if (board.checkTie()) {
				System.out.println("Tie!");
			}
			if (board.checkForWin(insertCol) || board.checkTie()) {
				// if either a win or tie occurs, asks if the user wants to play again.
				// acceptable answers include Y, y, N, n.
				do {
					System.out.println("Would you like to play again? Y/N");
					choice = scan.next().charAt(0);
				} while (choice != 'Y' && choice != 'y' && choice != 'N' && choice != 'n');

				// resets GameBoard and the player marker
				if (choice == 'y' || choice == 'Y') {
					board = new GameBoard();
					player = 'X';
					System.out.println(board.toString());
				}
			} else {
				// if the move didn't result in a tie or a win, proceed with the game and switch players
				if (player == 'X')
					player = 'O';
				else
					player = 'X';
			}
		} while (choice == 'Y' || choice == 'y');

	}
}

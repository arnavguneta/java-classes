package cpsc2150.connectX;

import java.util.Scanner;

public class Connect4Game {
	public static void main(String[] args) {
		// initializes gameboard with dummy values (changed with input from user later)
		IGameBoard board = new GameBoard(0, 0, 0);
		Scanner scan = new Scanner(System.in);
		// initial values for the gameboard
		char choice = 'Y', player = 'X';
		int insertCol = -1, rows, cols, inARow;
		// boolean used to check if gameboard needs to be reinitialized
		boolean gameEnd = true;

		// main loop, keep the game going till the user answers N/n
		do {
			// if the game has ended, reinitialize gameboard
			if (gameEnd) {
				// asks user for number of rows input, ensures 3 <= rows <= MAX_ROW
				do {
					System.out.println("How many rows should be on the board?");
					rows = scan.nextInt();
					if (rows < 3)
						System.out.println("Must have at least 3 rows.");
					else if (rows > IGameBoard.MAX_ROW)
						System.out.println("Can have at most " + (IGameBoard.MAX_ROW) + " rows");
				} while (rows < 3 || rows > IGameBoard.MAX_ROW);

				// asks user for number of columns input, ensures 3 <= cols <= MAX_COLUMN
				do {
					System.out.println("How many columns should be on the board?");
					cols = scan.nextInt();
					if (cols < 3)
						System.out.println("Must have at least 3 columns.");
					else if (cols > IGameBoard.MAX_COLUMN)
						System.out.println("Can have at most " + (IGameBoard.MAX_COLUMN) + " columns");
				} while (cols < 3 || cols > IGameBoard.MAX_COLUMN);

				// asks user for number of markers needed in a row to win input, ensures 3 <= inARow <= MAX_IN_A_ROW
				do {
					System.out.println("How many in a row to win?");
					inARow = scan.nextInt();
					if (inARow < 3)
						System.out.println("Must have at least 3 in a row to win.");
					else if (inARow > IGameBoard.MAX_IN_A_ROW)
						System.out.println("Can have at most " + (IGameBoard.MAX_IN_A_ROW) + " in a row to win");
				} while (inARow < 3 || inARow > IGameBoard.MAX_IN_A_ROW);

				// initializes game board and prints it out
				board = new GameBoard(rows, cols, inARow);
				System.out.println(board.toString());
			}

			// loop to obtain column value, ensures 0 < insertCol < MAX_COLUMN and checkIfFree == true
			do {
				System.out.println("Player " + player + ", what column do you want to place your marker in?");
				insertCol = scan.nextInt();
				if (insertCol < 0)
					System.out.println("Column cannot be less than 0");
				else if (insertCol >= board.getNumRows())
					System.out.println("Column cannot be greater than " + (board.getNumColumns() - 1));
				else if (!board.checkIfFree(insertCol))
					System.out.println("Column is full");
			} while (insertCol < 0 || insertCol >= board.getNumColumns() || !board.checkIfFree(insertCol));

			// places token in the designated column and prints the board
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

				// resets the player marker
				if (choice == 'y' || choice == 'Y') {
					player = 'X';
				}

				// the game ends, necessary to reinitialize board if user answers Y/y
				gameEnd = true;
			} else {
				// if the move didn't result in a tie or a win, proceed with the game and switch players
				if (player == 'X')
					player = 'O';
				else
					player = 'X';

				// game has not ended, necessary to skip reinitialization loop
				gameEnd = false;
			}
		} while (choice == 'Y' || choice == 'y');

	}
}

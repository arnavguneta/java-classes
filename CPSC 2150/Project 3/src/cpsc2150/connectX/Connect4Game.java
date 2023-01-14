package cpsc2150.connectX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connect4Game {
	public static void main(String[] args) {
		// initializes gameboard with dummy values (changed with input from user later)
		IGameBoard board = new GameBoard(0, 0, 0);
		Scanner scan = new Scanner(System.in);
		// initial values for the gameboard
		char choice = 'Y', player = ' ';
		int insertCol = -1, rows, cols, inARow, players = 0, MIN_PLAYERS = 2, MAX_PLAYERS = 10, currentPlayer = 0, MIN_ROW = 3, MIN_COL = 3, MIN_INAROW = 3;
		// boolean used to check if gameboard needs to be reinitialized
		boolean gameEnd = true;
		// list of player characters
		List<Character> playerTokens = new ArrayList<>();

		// main loop, keep the game going till the user answers N/n
		do {
			// if the game has ended, reinitialize gameboard
			if (gameEnd) {
				// asks user for number of players, ensures 2 <= players <= 10
				do {
					System.out.println("How many players?");
					players = scan.nextInt();
					if (players > MAX_PLAYERS)
						System.out.println("Must be 10 players or fewer");
					else if (players < MIN_PLAYERS)
						System.out.println("Must be at least 2 players");
				} while (players < MIN_PLAYERS || players > MAX_PLAYERS);

				// asks the user for a token for every user
				for (int i = 1; i <= players; i++) {
					do {
						System.out.println("Enter the character to represent player " + i);
						player = scan.next().toUpperCase().charAt(0);

						if (playerTokens.contains(player))
							System.out.println(player + " is already taken as a player token!");
					} while (playerTokens.contains(player));
					playerTokens.add(player);
				}

				// asks user for number of rows input, ensures 3 <= rows <= MAX_ROW
				do {
					System.out.println("How many rows should be on the board?");
					rows = scan.nextInt();
					if (rows < MIN_ROW)
						System.out.println("Must have at least 3 rows.");
					else if (rows > IGameBoard.MAX_ROW)
						System.out.println("Can have at most " + (IGameBoard.MAX_ROW) + " rows");
				} while (rows < MIN_ROW || rows > IGameBoard.MAX_ROW);

				// asks user for number of columns input, ensures 3 <= cols <= MAX_COLUMN
				do {
					System.out.println("How many columns should be on the board?");
					cols = scan.nextInt();
					if (cols < MIN_COL)
						System.out.println("Must have at least 3 columns.");
					else if (cols > IGameBoard.MAX_COLUMN)
						System.out.println("Can have at most " + (IGameBoard.MAX_COLUMN) + " columns");
				} while (cols < MIN_COL || cols > IGameBoard.MAX_COLUMN);

				// asks user for number of markers needed in a row to win input, ensures 3 <= inARow <= MAX_IN_A_ROW
				do {
					System.out.println("How many in a row to win?");
					inARow = scan.nextInt();
					if (inARow < MIN_INAROW)
						System.out.println("Must have at least 3 in a row to win.");
					else if (inARow > IGameBoard.MAX_IN_A_ROW)
						System.out.println("Can have at most " + (IGameBoard.MAX_IN_A_ROW) + " in a row to win");
				} while (inARow < MIN_INAROW || inARow > IGameBoard.MAX_IN_A_ROW);

				// asks user for fast or efficient implementation
				do {
					System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
					choice = scan.next().charAt(0);
					if (choice != 'f' && choice != 'F' && choice != 'M' && choice != 'm')
						System.out.println("Please enter F or M");
				} while (choice != 'f' && choice != 'F' && choice != 'M' && choice != 'm');

				// initializes game board and prints it out
				if (choice == 'F' || choice == 'f')
					board = new GameBoard(rows, cols, inARow);
				else
					board = new GameBoardMem(rows, cols, inARow);
				System.out.println(board.toString());
			}

			// user choice for now is to keep looping until someone wins
			choice = 'Y';

			// loop to obtain column value, ensures 0 < insertCol < MAX_COLUMN and checkIfFree == true
			do {
				System.out.println("Player " + playerTokens.get(currentPlayer) + ", what column do you want to place your marker in?");
				insertCol = scan.nextInt();
				if (insertCol < 0)
					System.out.println("Column cannot be less than 0");
				else if (insertCol >= board.getNumRows())
					System.out.println("Column cannot be greater than " + (board.getNumColumns() - 1));
				else if (!board.checkIfFree(insertCol))
					System.out.println("Column is full");
			} while (insertCol < 0 || insertCol >= board.getNumColumns() || !board.checkIfFree(insertCol));

			// places token in the designated column and prints the board
			board.placeToken(playerTokens.get(currentPlayer), insertCol);
			System.out.println(board.toString());

			// checks for a win/tie
			if (board.checkForWin(insertCol)) {
				System.out.println("Player " + playerTokens.get(currentPlayer) + " Won!");
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

				// resets to player 1 at start
				currentPlayer = 0;

				// clears tokens list
				playerTokens.clear();

				// the game ends, necessary to reinitialize board if user answers Y/y
				gameEnd = true;
			} else {
				// if the move didn't result in a tie or a win, proceed with the game and switch players
				if (currentPlayer == playerTokens.size() - 1) {
					currentPlayer = 0;
				} else {
					currentPlayer++;
				}

				// game has not ended, necessary to skip reinitialization loop
				gameEnd = false;
			}
		} while (choice == 'Y' || choice == 'y');

	}
}

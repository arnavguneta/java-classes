package cpsc2150.interfaces;

import java.util.Scanner;

public class SetApp {

	public static void main(String[] args) {

		int choice;
		Scanner scanner = new Scanner(System.in);
		ISet arraySet = new ArraySet();
		ISet listSet = new ListSet();

		do {
			System.out.println("Enter 1 for an array implementation or 2 for a list implementation.");
			choice = scanner.nextInt();
		} while (choice < 0 || choice > 2);

		if (choice == 1) {
			// if an arraySet is being used, call the setInit function with the appropriate params
			setInit(choice, arraySet, scanner);
		} else if (choice == 2) {
			// if a listSet is being used, call the setInit function with the appropriate params
			setInit(choice, listSet, scanner);
		}
	}

	/**
	 * @pre
	 * set instanceof arraySet or listSet
	 * @post
	 * handles all output and input
	 * @param choice the integer that the user picks
	 * @param set the set which the operations should be done to
	 * @param scanner scanner that is used to read in the values
	 */
	static private void setInit(int choice, ISet set, Scanner scanner) {
		do {
			System.out.println("1. Add a value to the set \n2. Remove a value from the set \n3. Exit");
			choice = scanner.nextInt();

			if (choice == 1) {
				// check if the set is full (add)
				if (set.getSize() < ISet.MAX_SIZE) {
					System.out.println("What value would you like to add to the set?");
					choice = scanner.nextInt();
					set.add(choice);
					System.out.println(set.toString());
				} else {
					System.out.println("Can't add more values to this set!");
					System.out.println(set.toString());
				}
				// resets choice in case the user tries to add a 3 (misinterpreted as exit case)
				choice = 0;
			} else if (choice == 2) {
				// check if array isn't empty
				if (set.getSize() > 0) {
					System.out.println("What position would you like to remove from the set?");
					choice = scanner.nextInt();

					// checks if the position is valid
					if (choice < 0 || choice > set.getSize() - 1) {
						System.out.println("That's not a valid position.");
					} else {
						set.removePos(choice);
						System.out.println(set.toString());
					}
				} else {
					System.out.println("Can't remove from an empty set!");
					System.out.println(set.toString());
				}
				// resets choice in case the user tries to remove a value from index 3 (misinterpreted as exit case)
				choice = 0;
			} else if (choice == 3){
				// exit case
				return;
			}
		} while (choice != 3);
	}
}

package cpsc2150.interfaces;

import java.util.Scanner;

public class DoubleSetApp {
	public static void main(String[] args) {

		int choice, permMenuChoice, sets = 0;
		Scanner scanner = new Scanner(System.in);
		// dummy initialization
		ISet<Double> set1 = new ArraySet<>();
		ISet<Double> set2 = new ArraySet<>();

		do {
			sets = 0;

			// asks to make a selection
			do {
				System.out.println("Make a selection");
				System.out.println("1. Find the Union of Two Sets\n2. Find the Intersection of Two Sets\n" +
						"3. Find the Difference of Two Sets\n4. See if two sets are equal\n5. Exit");
				permMenuChoice = scanner.nextInt();
			} while (permMenuChoice < 1 || permMenuChoice > 5);

			// initializes two sets
			do {
				// defines which set is being initialized
				sets++;

				if (permMenuChoice == 5)
					return;

				System.out.println("Make set " + sets);

				// asks what implementation should be used
				do {
					System.out.println("Enter 1 for an array implementation or 2 for a list implementation.");
					choice = scanner.nextInt();
				} while (choice < 0 || choice > 2);

				if (choice == 1) {
					// if an arraySet is being used, call the setInit function with the appropriate params
					// sets = 1 when first set is being populated, 2 when second set is being populated
					if (sets == 1) {
						set1 = new ArraySet<>();
						setInit(set1, scanner);
					} else {
						set2 = new ArraySet<>();
						setInit(set2, scanner);
					}

				} else if (choice == 2) {
					// if a listSet is being used, call the setInit function with the appropriate params
					if (sets == 1) {
						set1 = new ListSet<>();
						setInit(set1, scanner);
					} else {
						set2 = new ListSet<>();
						setInit(set2, scanner);
					}
				}
			} while (sets < 2);

			// output
			System.out.println("Set 1 is: ");
			System.out.println(set1.toString());
			System.out.println("Set 2 is: ");
			System.out.println(set2.toString());


			// calls the appropriate function based on what the user chose in the first place
			if (permMenuChoice == 1) {
				System.out.println("The union is: ");
				set1.union(set2);
				System.out.println(set1.toString());
			} else if (permMenuChoice == 2) {
				System.out.println("The intersection is: ");
				set1.intersect(set2);
				System.out.println(set1.toString());
			} else if (permMenuChoice == 3) {
				System.out.println("The difference is: ");
				set1.difference(set2);
				System.out.println(set1.toString());
			} else if (permMenuChoice == 4) {
				if (set1.equals(set2))
					System.out.println("The sets are equal!");
				else
					System.out.println("The sets are not equal!");
			}
		} while (permMenuChoice != 5);

	}


	/**
	 * @param set     the set which the operations should be done to
	 * @param scanner scanner that is used to read in the values
	 * @pre set instanceof arraySet or listSet
	 * @post handles all output and input
	 */
	static private void setInit(ISet<Double> set, Scanner scanner) {
		String c = "";
		double insertSet;
		do {
			// check if the set is full (add)
			if (set.getSize() < ISet.MAX_SIZE) {
				System.out.println("Enter a value to add to the set. Enter q to stop adding to the set.");
				c = scanner.next();
				if (c.equalsIgnoreCase("q")) {
					return;
				}
				insertSet = Double.parseDouble(c);

				if (!set.contains(insertSet))
					set.add(insertSet);
				else
					System.out.println("The value is already in the set");
			} else {
				System.out.println("Can't add more values to this set!");
				System.out.println(set.toString());
			}
		} while (!c.equalsIgnoreCase("q") );
	}
}

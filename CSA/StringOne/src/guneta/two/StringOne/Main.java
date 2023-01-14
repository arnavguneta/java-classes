package guneta.two.StringOne;

/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
10/12/17 
 */
public class Main {

	public static void main(String args[]) {

		String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Morbi tristique ipsum ante, quis dapibus mauris congue nec. "
				+ "Pellentesque habitant morbi tristique senectus et netus et "
				+ "malesuada fames ac turpis egestas. Ut malesuada dignissim felis "
				+ "ac tempus. Mauris sed elit et libero bibendum egestas. Morbi non "
				+ "nisl hendrerit, porttitor mi vel, venenatis mi. Morbi nec odio "
				+ "finibus urna maximus aliquet sed non augue. Proin pellentesque "
				+ "justo vitae auctor finibus. Lorem ipsum dolor sit amet, consectetur "
				+ "adipiscing elit. Mauris in felis odio. Proin egestas augue sit amet "
				+ "laoreet consectetur. Sed elit purus, aliquam vitae ultrices luctus,"
				+ " interdum sed dolor. Curabitur faucibus commodo.";

		System.out.println("Original string: " + s);
		int n = s.length();
		System.out.println("The length of the string is: " + n);
		System.out.println("The last character of the string is: " + s.charAt(n-1));
		if (s.equalsIgnoreCase("Arnav")) {
			System.out.println("The string is Arnav.");
		} else {
			System.out.println("The string is not Arnav.");
		}
		System.out.println("The string, all upper case: " + s.toUpperCase());
		System.out.println("The string, all lower case:" + s.toLowerCase());
		System.out.println("Concatanated string: " + s.concat("Arnav was here"));
		if (s.isEmpty()) {
			System.out.println("The string is not null.");
		} else {
			System.out.println("The string is null.");
		}
		System.out.println("The last position of 'A': " + s.lastIndexOf('a'));

		// 1
		System.out.println("The string contains \"Lorem\": " + s.contentEquals("Lorem"));

		char charArray[] = s.toCharArray();
		System.out.println("The first letter of the string is: " + charArray[0]);

		System.out.println("All Os are replaced by Ys: " + s.replace('o', 'y'));
		System.out.println("Trimmed string: " + s.trim());
	}
}

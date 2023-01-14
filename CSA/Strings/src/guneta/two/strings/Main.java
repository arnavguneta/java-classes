package guneta.two.strings;

/*
APCS-A PSET 2-2
Arnav Guneta
Period 2
Johns Creek High School
10/10/17 
 */
public class Main {

	public static void main(String args[]) {
		String s = "Hello World";

		char helloArray[] = {'H','e', 'l','l', 'o'};

		String hello = new String(helloArray);
		System.out.println(hello);

		int length = s.length();

		String conc = "Hello, ".concat(s);
		System.out.println(conc);

		if (conc.equalsIgnoreCase(s)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

		char x = conc.charAt(2);
		System.out.println(x);
	}

}

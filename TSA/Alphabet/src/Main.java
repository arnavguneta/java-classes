import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	static String s;
	static int i;
	static int count;

	public static void main(String[] args) {
		String line = null;
		List<String> lines = new ArrayList<>();

		try {
			FileReader freader = new FileReader("input.txt");
			BufferedReader breader = new BufferedReader(freader);

			while ((line = breader.readLine()) != null) {
				lines.add(line);
			}

			for (String s : lines) {
				Main.s = s;
				char chars[] = s.toCharArray();

				for(int i = 0; i < s.length(); i++) {
					Main.i = i;
					if (chars[i] == 'a') {
						// character is the char that is checked for, postion is the number of positions away from A.
						checkAlphabet('b', 1);
						checkAlphabet('c', 2);
						checkAlphabet('d', 3);
						checkAlphabet('e', 4);
						checkAlphabet('f', 5);
						checkAlphabet('g', 6);
						checkAlphabet('h', 7);
						checkAlphabet('i', 8);
						checkAlphabet('j', 9);
						checkAlphabet('k', 10);
						checkAlphabet('l', 11);
						checkAlphabet('m', 12);
						checkAlphabet('n', 13);
						checkAlphabet('o', 14);


					}

				}

				System.out.println(count);
				count = 0;
			}

			//97-122
			System.out.println("done");

			breader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static void checkAlphabet(char c, int pos) {
		char chars[] = s.toCharArray();

		if ((i+pos) < s.length() && !(chars[i+pos] == c)) {
			count++;
		}

	}

}

import java.util.Scanner;

/*
Arnav Guneta (aguneta)
CPSC 2310-01
Assignment 2
10/25/19
This program accepts two ints and multiplies them together, displaying the step
by step hardware multiplication algorithm
*/

// TODO fix hard wrap to 80

public class multiply {

	// converts [decimal] into a byte sized binary string
	static String decimalToBinary(int decimal) {
		String binary = Integer.toBinaryString(decimal);
		String cat = "";
		for (int i = 1; i <= 8 - binary.length(); i++) {
			cat += "0";
		}
		binary = cat + binary;

		return binary;
	}

	// adds two binary byte sized strings: [num] + [operand]
	// return string has carry
	static String addBinary(String num, String operand) {
		String result = "";
		int sum = 0;

		// iterate backwards through the strings
		int i = num.length() - 1, j = operand.length() - 1;
		while (i >= 0 || j >= 0 || sum == 1) {
			sum += ((i >= 0) ? num.charAt(i) - '0' : 0);
			sum += ((j >= 0) ? operand.charAt(j) - '0' : 0);
			result = (char) (sum % 2 + '0') + result;
			sum /= 2;
			i--;
			j--;
		}
		return result;
	}

	public static void main(String args[]) {

		int multiplier, multiplicand, carry = 0;
		Scanner scanner = new Scanner(System.in);

		String divider = "---------------------------------------------------";
		String acc = "00000000";
		// combination of carry,acc,mq
		String buffer = "";

		System.out.print("multiplicand: ");
		multiplicand = Integer.parseInt(scanner.nextLine());
		System.out.print("multiplier: ");
		multiplier = Integer.parseInt(scanner.nextLine());

		if (multiplicand < 0 || multiplicand > 255 || multiplier < 0
				|| multiplier > 255) {
			System.out.println(
					"Multiplier and multiplicand should be between 0 and 255.");
			return;
		}

		String multiplicand_binary = decimalToBinary(multiplicand);
		String multiplier_binary = decimalToBinary(multiplier);

		System.out.println("\nc and acc set to 0");
		System.out.println(
				"mq set to multiplier    =  " + multiplier + " decimal and "
						+ multiplier_binary + " binary");
		System.out.println(
				"mdr set to multiplicand =  " + multiplicand + " decimal and "
						+ multiplicand_binary + " binary");
		// sets up buffer string
		buffer = carry + acc + multiplier_binary;
		for (int i = 1; i <= 8; i++) {
			System.out.println(divider);
			System.out.println(
					"step " + i + ":   " + buffer.charAt(0) + " " + buffer
							.substring(1, 9) + " " + buffer.substring(9));
			// check lsb, determines if addition is neccesarry
			if (buffer.charAt(16) == '1') {
				System.out.println("        +   " + multiplicand_binary
						+ "        ^ add based on lsb=1");
				System.out.println("          ----------");
				acc = addBinary(buffer.substring(1, 9), multiplicand_binary);
				// if the addition had a carry, update that in buffer and remove from acc
				if (acc.length() > 8) {
					buffer = "1" + acc.substring(1) + buffer.substring(9);
				} else {
					buffer = buffer.charAt(0) + acc + buffer.substring(9);
				}
			} else {
				System.out.println("        +   " + "00000000"
						+ "        ^ no add based on lsb=0");
				System.out.println("          ----------");
			}

			System.out.println("          " + buffer.charAt(0) + " " + buffer
					.substring(1, 9) + " " + buffer.substring(9));
			System.out.println("       >>                     shift right");
			// logical shift right
			buffer = "0" + buffer.substring(0, buffer.length() - 1);
			System.out.println("          " + buffer.charAt(0) + " " + buffer
					.substring(1, 9) + " " + buffer.substring(9));
		}
		System.out.println(divider);
		System.out.println("check:                 binary   decimal");
		System.out.println(
				"                     " + multiplicand_binary + "        "
						+ multiplicand);
		System.out.println(
				"           x         " + multiplier_binary + "  x     "
						+ multiplier);
		System.out.println("             ----------------    ------");
		System.out.println(
				"             " + buffer.substring(1) + "      " + (multiplicand
						* multiplier));

	}

}

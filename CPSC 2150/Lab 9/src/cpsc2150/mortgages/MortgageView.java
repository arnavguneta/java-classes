package cpsc2150.mortgages;

import java.util.Scanner;

public class MortgageView implements IMortgageView {

	private IMortgageController c;
	private Scanner scanner = new Scanner(System.in);

	@Override public void setController(IMortgageController c) {
		this.c = c;
	}

	@Override public double getHouseCost() {
		System.out.println("How much does the house cost?");
		return scanner.nextDouble();
	}

	@Override public double getDownPayment() {
		System.out.println("How much is the down payment?");
		return scanner.nextDouble();
	}

	@Override public int getYears() {
		System.out.println("How many years?");
		return scanner.nextInt();
	}

	@Override public double getMonthlyDebt() {
		System.out.println("How much are your monthly debt payments?");
		return scanner.nextDouble();
	}

	@Override public double getYearlyIncome() {
		System.out.println("How much is your yearly income?");
		return scanner.nextDouble();
	}

	@Override public int getCreditScore() {
		System.out.println("What is your credit score?");
		return scanner.nextInt();
	}

	@Override public String getName() {
		System.out.println("What's your name?");
		return scanner.next();
	}

	@Override public void printToUser(String s) {
		System.out.println(s);
	}

	@Override public void displayPayment(double p) {
		System.out.println("Monthly Payment: $" + p);
	}

	@Override public void displayRate(double r) {
		r *= PERCENTAGE_CONVERTER;
		System.out.println("Interest Rate: " + r + "%");
	}

	@Override public void displayApproved(boolean a) {
		System.out.println("Approved: " + a);
	}

	@Override public boolean getAnotherMortgage() {
		System.out.println("Would you like to apply for another mortgage? Y/N");
		String ans = scanner.next();
		if (ans.equalsIgnoreCase("y"))
			return true;
		else
			return false;
	}

	@Override public boolean getAnotherCustomer() {
		System.out.println("Would you like to consider another customer? Y/N");
		String ans = scanner.next();
		if (ans.equalsIgnoreCase("y"))
			return true;
		else
			return false;
	}
}

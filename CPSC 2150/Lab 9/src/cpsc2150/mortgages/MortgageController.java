package cpsc2150.mortgages;


public class MortgageController implements IMortgageController{

	private IMortgageView view;

	public MortgageController(IMortgageView view) {
		this.view = view;
	}

	@Override public void submitApplication() {
		String name;
		double income, debt, houseCost, downPayment;
		int score, years;
		boolean newMortgage = true, newCustomer = true;

		// loops to initialize customer and mortgage depending on customer input
		do {
			name = view.getName();

			// loops to get income value, verifies preconditions
			do {
				income = view.getYearlyIncome();
				if (income <= 0) {
					System.out.println("Income must be greater than 0.");
				}
			} while (income <= 0);

			// loops to get debt value, verifies preconditions
			do {
				debt = view.getMonthlyDebt();
				if (debt < 0) {
					System.out.println("Debt must be greater than or equal to 0.");
				}
			} while (debt < 0);

			// loops to get credit score, verifies preconditions
			do {
				score = view.getCreditScore();
				if (score <= 0 || score >= MAX_CREDIT_SCORE) {
					System.out.println("Credit Score must be greater than 0 and less than " + MAX_CREDIT_SCORE);
				}
			} while (score <= 0 || score >= MAX_CREDIT_SCORE);

			// creates the new customer object with new input values obtained from the user
			ICustomer customer = new Customer(debt, income, score, name);

			// loops to initialize mortgage depending on user input
			do {
				// loops to get house cost, verifies preconditions
				do {
					houseCost = view.getHouseCost();
					if (houseCost <= 0) {
						System.out.println("Cost must be greater than 0.");
					}
				} while (houseCost <= 0);

				// loops to get down payment, verifies preconditions
				do {
					downPayment = view.getDownPayment();
					if (downPayment <= 0 || downPayment >= houseCost) {
						System.out.println("Down Payment must be greater than 0 and less than the cost of the house.");
					}
				} while (downPayment <= 0 || downPayment >= houseCost);

				// loops to get years, verifies preconditions
				do {
					years = view.getYears();
					if (years <= 0) {
						System.out.println("Years must be greater than 0.");
					}
				} while (years <= 0);

				// creates the new mortgage object with new input values obtained from the user
				IMortgage mortgage = new Mortgage(houseCost, downPayment, years, customer);

				// prints the info to the user
				view.printToUser("Name: " + customer.getName());
				view.printToUser("Income: " + customer.getIncome());
				view.printToUser("Credit Score: " + customer.getCreditScore());
				view.printToUser("Monthly Debt: $" + customer.getMonthlyDebtPayments());
				view.printToUser("Mortgage info:");
				view.printToUser("Principal Amount: $" + mortgage.getPrincipal());
				view.displayRate(mortgage.getRate());
				view.printToUser("Term: " + mortgage.getYears() + " years");
				view.displayPayment(mortgage.getPayment());
				view.printToUser("");

				// prompts user to check if they want to enter a new mortgage
				newMortgage = view.getAnotherMortgage();

			} while (newMortgage);

			// prompts user to check they want to enter a new customer
			newCustomer = view.getAnotherCustomer();

		} while (newCustomer);


	}
}

package cpsc2150.mortgages;

public class MortgageController implements IMortgageController {

	private IMortgageView view;

	public MortgageController(IMortgageView view) {
		this.view = view;
	}

	@Override public void submitApplication() {
		String name;
		double income, debt, houseCost, downPayment;
		int score, years;

		name = view.getName();

		// loops to get income value, verifies preconditions
		do {
			income = view.getYearlyIncome();
			if (income <= 0) {
				view.printToUser("Income must be greater than 0.");
			}
		} while (income <= 0);

		// loops to get debt value, verifies preconditions
		do {
			debt = view.getMonthlyDebt();
			if (debt < 0) {
				view.printToUser("Debt must be greater than or equal to 0.");
			}
		} while (debt < 0);

		// loops to get credit score, verifies preconditions
		do {
			score = view.getCreditScore();
			if (score <= 0 || score >= MAX_CREDIT_SCORE) {
				view.printToUser("Credit Score must be greater than 0 and less than " + MAX_CREDIT_SCORE);
			}
		} while (score <= 0 || score >= MAX_CREDIT_SCORE);

		// creates the new customer object with new input values obtained from the user
		ICustomer customer = new Customer(debt, income, score, name);

		// loops to get house cost, verifies preconditions
		do {
			houseCost = view.getHouseCost();
			if (houseCost <= 0) {
				view.printToUser("Cost must be greater than 0.");
			}
		} while (houseCost <= 0);

		// loops to get down payment, verifies preconditions
		do {
			downPayment = view.getDownPayment();
			if (downPayment <= 0 || downPayment >= houseCost) {
				view.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");
			}
		} while (downPayment <= 0 || downPayment >= houseCost);

		// loops to get years, verifies preconditions
		do {
			years = view.getYears();
			if (years <= 0) {
				view.printToUser("Years must be greater than 0.");
			}
		} while (years <= 0);

		// creates the new mortgage object with new input values obtained from the user
		IMortgage mortgage = new Mortgage(houseCost, downPayment, years, customer);

		// if the loan is approved, update the GUI with appropriate values. else, set payment and rate to 0
		if (mortgage.loanApproved()) {
			view.displayApproved(true);
			view.displayPayment(mortgage.getPayment());
			view.displayRate(mortgage.getRate());
		} else {
			view.displayApproved(false);
			view.displayPayment(0);
			view.displayRate(0);
		}
	}
}

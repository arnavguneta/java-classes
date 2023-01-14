package cpsc2150.mortgages;

/**
 * @invariants 0 < years
 *
 * Correspondences: payment = Payment
 * 					rate = Rate
 * 					customer = cpsc2150.mortgages.Customer
 * 					debtToIncomeRatio = DebtToIncomeRatio
 * 					principal = Principal
 * 					numberOfPayments = NumberOfPayments
 * 					percentDown	= PercentDown
 */
public class Mortgage extends AbsMortgage implements IMortgage{

	private double payment, rate, debtToIncomeRatio, principal, numberOfPayments, percentDown;
	// Additional APR rate increments
	private double LOWPERCENTDOWNADD = .005, GOODYEARSADD = .005, BADYEARSADD = .01;
	// months in a year constant
	private final int monthsInAYear= 12;
	private int years;
	private ICustomer customer;
	/**
	 * @pre none
	 * @post Rate is calculated based on the BASERATE, the years for the loan, and the PercentDown]
	 *       [Payment is calculated]
	 * @param costOfHome the cost of the house
	 * @param downPayment the amount paid up front
	 * @param years for the mortgage
	 * @param customer the customer associated with the mortgage
	 */
	public Mortgage(double costOfHome, double downPayment, int years, ICustomer customer) {
		principal = costOfHome - downPayment;
		percentDown = downPayment / costOfHome;
		numberOfPayments = monthsInAYear * years;
		this.years = years;
		this.customer = customer;

		// rate calculation
		rate = BASERATE;
		// if the loan is for less years than the max years, add .5%, else add 1%
		if (years < MAX_YEARS)
			rate += GOODYEARSADD;
		else
			rate += BADYEARSADD;

		// if percent down is less than preferred percent down,  add .5%
		if (percentDown < PREFERRED_PERCENT_DOWN)
			rate += LOWPERCENTDOWNADD;

		if (customer.getCreditScore() < BADCREDIT)
			rate += VERYBADRATEADD;
		else if (customer.getCreditScore() < FAIRCREDIT)
			rate += BADRATEADD;
		else if (customer.getCreditScore() < GOODCREDIT)
			rate += NORMALRATEADD;
		else if (customer.getCreditScore() < GREATCREDIT)
			rate += GOODRATEADD;

		payment = (rate/12 * principal) / (1 - Math.pow((1 + rate/12), -numberOfPayments));
		debtToIncomeRatio = (customer.getMonthlyDebtPayments() + payment) / (customer.getIncome()/12);
	}

	@Override public boolean loanApproved() {
		if (rate >= RATETOOHIGH || percentDown < MIN_PERCENT_DOWN || debtToIncomeRatio > DTOITOOHIGH)
			return false;
		return true;
	}

	@Override public double getPayment() {
		return payment;
	}

	@Override public double getRate() {
		return rate;
	}

	@Override public double getPrincipal() {
		return principal;
	}

	@Override public int getYears() {
		return years;
	}
}

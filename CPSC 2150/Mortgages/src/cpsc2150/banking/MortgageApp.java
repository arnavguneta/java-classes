package cpsc2150.banking;

/**
 * Created by kplis on 1/23/2018.
 */
public class MortgageApp {

    public static void main(String [] args)
    {
        //mortgage constructor
        double cost = 150000;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = new Customer(debt, inc, score, name);
        IMortgage m = new Mortgage(cost, dp, y, c);

        System.out.println("PAYMENT IS " + m.getPayment());

        //16200.000000000002

    }
}

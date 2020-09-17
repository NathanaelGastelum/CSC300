import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Portfolio {

    private String portfolioName;
    private ArrayList<Investment> portfolioInvestments = new ArrayList<Investment>();
    private Random randy;
    public Scanner keyboard = new Scanner(System.in);


    public Portfolio() {
        this.portfolioName = "none";
    }

    public Portfolio(String portfolioName, long seed) {
        this.portfolioName = portfolioName;
        this.randy = new Random(seed);
    }

    public void initializePortfolio() throws IOException {
        System.out.println("Input filename: ");
        Scanner input = new Scanner(new File(keyboard.nextLine()));

        while (input.hasNextLine()) {
            String[] investment = input.nextLine().split(" ");
            switch (investment[0]) {
                case "Stock":
                    portfolioInvestments.add(new Stock(investment[1], Double.parseDouble(investment[2]), Integer.parseInt(investment[3])));
                    break;
                case "Bond":
                    portfolioInvestments.add(new Bond(investment[1], Double.parseDouble(investment[2]), Integer.parseInt(investment[3]), Double.parseDouble(investment[4])));
                    break;
                case "SavingsAccount":
                    portfolioInvestments.add(new SavingsAccount(investment[1], investment[2], Double.parseDouble(investment[3]), Double.parseDouble(investment[4])));
                    break;
                case "CheckingAccount":
                    portfolioInvestments.add(new CheckingAccount(investment[1], investment[2], Double.parseDouble(investment[3]), Double.parseDouble(investment[4]),
                            Double.parseDouble(investment[5]), Double.parseDouble(investment[6])));
                    break;
            }
        }
        input.close();
    }

    public void modelPortfolio(int months) {
        for (int i = 0; i < months; i++) {
            for (Investment investment : portfolioInvestments) {
                if (investment.getType() == "Stock") {
                    if (i % 3 == 0) {
                        double priceChange = ((Stock) investment).getPricePerShare() * ((randy.nextDouble() * 30 - 10) * .01) + ((Stock) investment).getPricePerShare();
                        double dividendPercent = randy.nextDouble() * 5 * .01;
                        ((Stock) investment).calcStockValues(priceChange, dividendPercent);
                    }
                }
                else if (investment.getType() == "Bond") {
                    ((Bond) investment).calcBondValues();
                }
                else if (investment.getType() == "SavingsAccount") {
                    for (int j = 0; j < 3; j++) {
                        double deposit = randy.nextDouble() * 1600 - 600;
                        if (deposit > 0) {
                            ((SavingsAccount) investment).makeDeposit(deposit);
                        }
                        else {
                            ((SavingsAccount) investment).makeWithdrawal(deposit);
                        }
                        ((SavingsAccount) investment).calcValue();
                    }
                }
                else if (investment.getType() == "CheckingAccount") {
                    double deposit = randy.nextDouble() * 1000 + 500;
                    ((CheckingAccount) investment).makeDeposit(deposit);
                    for (int k = 0; k < 4; k++) {
                        double check = randy.nextDouble() * 290 + 10;
                        ((CheckingAccount) investment).writeCheck(check);
                    }
                    ((CheckingAccount) investment).calcValue();
                }
            }
        }
    }

    public void generatePortfolioReport(int months) throws IOException {
        System.out.println("Output filename: ");
        PrintWriter printWriter = new PrintWriter(new File(keyboard.nextLine()));

        double totalValue = 0;

        printWriter.printf("Results of the portfolio Computer Student over %d months\n", months);
        for (Investment investment : portfolioInvestments) {
            totalValue += investment.getInvestmentValue();
            printWriter.println(investment.toString() + "\n");
        }
        printWriter.printf("\nThe total value of all the investments is $%.2f", totalValue);
        printWriter.close();
    }
}
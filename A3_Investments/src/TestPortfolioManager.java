import java.io.IOException;
import java.util.Scanner;

public class TestPortfolioManager {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the name of the portfolio:");
        String name = input.nextLine();

        System.out.println("Please enter a seed to use to create a Random object in the portfolio:");
        int seed = input.nextInt();

        Portfolio portfolio = new Portfolio(name, seed);
        portfolio.initializePortfolio();

        System.out.println("Please enter the duration in months to model this portfolio:");
        int months = input.nextInt();

        portfolio.modelPortfolio(months);
        portfolio.generatePortfolioReport(months);
    }
}

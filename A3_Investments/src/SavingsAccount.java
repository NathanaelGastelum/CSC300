public class SavingsAccount extends BankAccount {

    private double annualInterestRatePercent;
    private double rate; // the prior value divided by 12 and by 100
    private double totalInterestEarned;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(String name, String accountNumber, double initialDeposit, double annualInterestRatePercent) {
        super("SavingsAccount ", name, accountNumber);
        setInvestmentValue(initialDeposit);
        setAnnualInterestRatePercent(annualInterestRatePercent);
    }

    public void makeDeposit(double deposit) {
        setInvestmentValue(getInvestmentValue() + deposit);
    }

    public boolean makeWithdrawal(double withdrawal) {
        if (getInvestmentValue() > withdrawal) {
            setInvestmentValue(getInvestmentValue() - withdrawal);
            return true;
        }
        else {
            System.out.println("Insufficient funds");
            return false;
        }
    }

    public void calcValue() {
        rate = annualInterestRatePercent / 12;
        double currentMonthInterest = rate * getInvestmentValue();
        setTotalInterestEarned(getTotalInterestEarned() + currentMonthInterest);
        setInvestmentValue(getInvestmentValue() + currentMonthInterest);
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("Current Value: $%.2f Interest Earned: %.2f",
                        getInvestmentValue(), totalInterestEarned);
    }

    public double getAnnualInterestRatePercent() {
        return annualInterestRatePercent;
    }

    public void setAnnualInterestRatePercent(double annualInterestRatePercent) {
        this.annualInterestRatePercent = annualInterestRatePercent  * 0.01;
    }

    public double getTotalInterestEarned() {
        return totalInterestEarned;
    }

    public void setTotalInterestEarned(double totalInterestEarned) {
        this.totalInterestEarned = totalInterestEarned;
    }
}
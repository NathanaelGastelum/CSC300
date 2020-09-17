public class CheckingAccount extends BankAccount {

    private double annualInterestRatePercent;
    private double rate; // the prior value divided by 12 and by 100
    private double totalInterestEarned;
    private double minimumCheckFreeBalance;
    private double checkCharge;
    private double totalCheckCharges;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(String name, String accountNumber, double initialDeposit, double annualInterestRatePercent, double minimumCheckFreeBalance, double checkCharge) {
        super("CheckingAccount", name, accountNumber);
        setInvestmentValue(initialDeposit);
        setAnnualInterestRatePercent(annualInterestRatePercent);
        setMinimumCheckFreeBalance(minimumCheckFreeBalance);
        setCheckCharge(checkCharge);
    }

    public void makeDeposit(double deposit) {
        setInvestmentValue(getInvestmentValue() + deposit);
    }

    public boolean writeCheck(double withdrawal) {
        if (getInvestmentValue() < withdrawal) {
            System.out.println("Insufficient funds");
            return false;
        }
        else if (getInvestmentValue() >= minimumCheckFreeBalance) {
            setInvestmentValue(getInvestmentValue() - withdrawal);
            return true;
        }
        else {
            setInvestmentValue(getInvestmentValue() - withdrawal - checkCharge);
            totalCheckCharges += checkCharge;
            return true;
        }
    }

    public void calcValue() {
        if (getInvestmentValue() >= minimumCheckFreeBalance) {
            rate = annualInterestRatePercent / 12;
            double currentMonthInterest = rate * getInvestmentValue();
            totalInterestEarned += currentMonthInterest;
            setInvestmentValue(getInvestmentValue() + currentMonthInterest);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("Current Value: $%.2f Interest Earned: %.2f Check Charges: $%.2f",
                        getInvestmentValue(), totalInterestEarned, totalCheckCharges);
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

    public double getMinimumCheckFreeBalance() {
        return minimumCheckFreeBalance;
    }

    public void setMinimumCheckFreeBalance(double minimumCheckFreeBalance) {
        this.minimumCheckFreeBalance = minimumCheckFreeBalance;
    }

    public double getCheckCharge() {
        return checkCharge;
    }

    public void setCheckCharge(double checkCharge) {
        this.checkCharge = checkCharge;
    }

    public double getTotalCheckCharges() {
        return totalCheckCharges;
    }

    public void setTotalCheckCharges(double totalCheckCharges) {
        this.totalCheckCharges = totalCheckCharges;
    }
}

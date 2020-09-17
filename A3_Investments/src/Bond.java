public class Bond extends Investment{

    private double pricePerBond, annualReturnPercentage, rate, cashEarnedToDate;
    private int numBondsOwned;

    public Bond(String name, double pricePerBond, int numBondsOwned, double annualReturnPercentage) {
        super("Bond", name);
        setPricePerBond(pricePerBond);
        setNumBondsOwned(numBondsOwned);
        setAnnualReturnPercentage(annualReturnPercentage);
        setInvestmentValue(numBondsOwned * pricePerBond);
    }

    public void calcBondValues() {
        cashEarnedToDate = cashEarnedToDate + ( (pricePerBond * annualReturnPercentage) / 12 );
        setInvestmentValue(pricePerBond*numBondsOwned + cashEarnedToDate);
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\nPrice Per Bond:: $%.2f Number Of Bonds: %d \n" +
                                "Current Value: $%.2f Cash On Hand To Date: %.2f",
                        pricePerBond, numBondsOwned, getInvestmentValue(), cashEarnedToDate);
    }

    public double getPricePerBond() {
        return pricePerBond;
    }

    public void setPricePerBond(double pricePerBond) {
        this.pricePerBond = pricePerBond;
    }

    public int getNumBondsOwned() {
        return numBondsOwned;
    }

    public void setNumBondsOwned(int numBondsOwned) {
        this.numBondsOwned = numBondsOwned;
    }

    public double getAnnualReturnPercentage() {
        return annualReturnPercentage;
    }

    public void setAnnualReturnPercentage(double annualReturnPercentage) {
        this.annualReturnPercentage = annualReturnPercentage;
    }
}

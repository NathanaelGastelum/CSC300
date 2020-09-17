public class Stock extends Investment {

    private double pricePerShare;
    private double numOfSharesOwned;
    private double dividendsEarnedToDate; // a percent of the investment paid annually

    public Stock() {
        super();
    }

    public Stock(String name, double pricePerShare, int numOfSharesOwned) {
        super("Stock", name);
        setPricePerShare(pricePerShare);
        setNumOfSharesOwned(numOfSharesOwned);
        setInvestmentValue(numOfSharesOwned * pricePerShare);
    }

    public void calcStockValues(double priceChange, double dividendPercent) {
        pricePerShare += priceChange;
        double currentDividend = pricePerShare*dividendPercent/100.0;
        dividendsEarnedToDate += currentDividend * numOfSharesOwned;
        if (currentDividend > 0) {
            numOfSharesOwned += currentDividend/pricePerShare;
        }
        setInvestmentValue(numOfSharesOwned * pricePerShare);
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\nPrice Per Share: $%.2f Number Of Shares: %.2f \n" +
                        "Current Value: $%.2f Investment Earnings to date: %.2f",
                        pricePerShare, numOfSharesOwned, getInvestmentValue(), dividendsEarnedToDate);
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public double getNumOfSharesOwned() {
        return numOfSharesOwned;
    }

    public void setNumOfSharesOwned(int numOfSharesOwned) {
        this.numOfSharesOwned = numOfSharesOwned;
    }
}

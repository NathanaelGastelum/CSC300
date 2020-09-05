public class CommissionEmployee {
    private final String firstName;
    private final String lastName;
    private double grossSales;
    private double commissionPercent;


    public CommissionEmployee(String firstName, String lastName, double grossSales, double commissionPercent) {
        this.firstName = firstName;
        this.lastName = lastName;
        setGrossSales(grossSales);
        setCommissionPercent(commissionPercent);
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public double getGrossSales() {
        return grossSales;
    }
    public double getCommissionPercent() {
        return commissionPercent;
    }

    public void setGrossSales(double grossSales) throws IllegalArgumentException {
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
        this.grossSales = grossSales;
    }

    public void setCommissionPercent(double commissionPercent) {
        if (commissionPercent < 0.0 || commissionPercent > 100.0) {
            throw new IllegalArgumentException("Commission rate must be >= 0.0 and <= 100.0");
        }
        this.commissionPercent = commissionPercent;
    }

    double earnings() {
        return grossSales * (commissionPercent/100.0);
    }

    public String toString() {
        return firstName + " " + lastName + " " + grossSales + " " + commissionPercent;
    }
}
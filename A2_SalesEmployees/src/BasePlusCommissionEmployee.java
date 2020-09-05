public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, double grossSales, double commissionPercent, double baseSalary) {
        super(firstName, lastName, grossSales, commissionPercent);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) throws IllegalArgumentException {
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    double earnings() {
        return super.earnings() + baseSalary;
    }

    @Override
    public String toString() {
        return super.toString() + " " + baseSalary;
    }
}

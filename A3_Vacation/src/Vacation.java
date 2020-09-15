import java.util.Objects;

public abstract class Vacation {

    private String destination;
    private double budget;


    protected Vacation(String destination, double budget) {
        setDestination(destination);
        setBudget(budget);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        if (budget >= 0){
            this.budget = budget;
        }
        else {
            throw new IllegalArgumentException("Budget must be >= 0.0");
        }
    }

    public abstract double overBudget();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return Math.abs(vacation.budget - budget) <= 0.0001 &&
                Objects.equals(destination, vacation.destination);
    }

    @Override
    public String toString() {
        return String.format("Destination: %s; Budget: $%.2f \n", destination, budget);
    }
}
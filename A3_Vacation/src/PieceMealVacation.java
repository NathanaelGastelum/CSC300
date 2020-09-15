import java.util.Arrays;

public class PieceMealVacation extends Vacation{

    private String [] items; // the list of items on the vacation
    private double [] costs; // the corresponding price of each item

    protected PieceMealVacation(String destination, double budget, String[] items, double[] costs) {
        super(destination, budget);
        setItems(items);
        setCosts(costs);
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            this.items[i] = items[i];
        }
    }

    public double[] getCosts() {
        return costs;
    }

    public void setCosts(double[] newCosts) {
        costs = new double[items.length];

        if (costs.length < newCosts.length) {
            for (int i = 0; i < costs.length; i++) {
                costs[i] = newCosts[i];
            }
        }
        else {
            for (int i = 0; i < costs.length; i++) {
                if(i < newCosts.length) {
                    costs[i] = newCosts[i];
                }
                else {
                    costs[i] = 0.0;
                }
            }
        }



    }

    @Override
    public double overBudget() {
        double sum = 0;
        for (double n : costs) {
            sum += n;
        }
        return this.getBudget() - sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PieceMealVacation that = (PieceMealVacation) o;
        return Arrays.equals(items, that.items) &&
                Arrays.equals(costs, that.costs);
    }

    @Override
    public String toString() {
        StringBuilder itemList = new StringBuilder();

        for (int i = 0; i < items.length; i++) {
            if (i == items.length - 1) {
                itemList.append(String.format("%s: $%.2f", items[i], costs[i]));
            } else {
                itemList.append(String.format("%s: $%.2f \n", items[i], costs[i]));
            }
        }

        return super.toString() + itemList;
    }
}

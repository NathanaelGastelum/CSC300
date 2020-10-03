import java.util.Comparator;

public class ComparatorSortOwnerID implements Comparator<Contractor> {
    @Override
    public int compare(Contractor o1, Contractor o2) {
        return Integer.compare(o1.getOwnerID(), o2.getOwnerID());
    }
}

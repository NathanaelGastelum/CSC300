import java.util.Comparator;

public class ComparatorMultiSort implements Comparator<Contractor> {
    @Override
    public int compare(Contractor o1, Contractor o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result != 0) {
            return result;
        }
        result = o1.getLocation().compareTo(o2.getLocation());
        if (result != 0) {
            return result;
        }
        return Integer.compare(o1.getOwnerID(), o2.getOwnerID());
    }
}

import java.util.Comparator;

public class ComparatorSortLocation implements Comparator<Contractor> {

    @Override
    public int compare(Contractor o1, Contractor o2) {
        return o1.getLocation().compareTo(o2.getLocation());
    }
}

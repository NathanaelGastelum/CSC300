import java.util.Comparator;

public class ComparatorSortName implements Comparator<Contractor> {
    @Override
    public int compare(Contractor o1, Contractor o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

import java.util.Comparator;

public class ComparatorDinosaur implements Comparator<Dinosaur> {

    @Override
    public int compare(Dinosaur o1, Dinosaur o2) {
        return Integer.compare(o1.getDinoWeight(), o2.getDinoWeight());
    }
}

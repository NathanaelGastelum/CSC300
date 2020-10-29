import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        Random randy = new Random(5);
        ArrayList<Integer> numAL = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numAL.add(randy.nextInt(7));
        }

        System.out.println("ArrayList: " + numAL);

        TreeSet<Integer> numTS = new TreeSet<>();
        Iterator<Integer> alIter = numAL.iterator();

        while (alIter.hasNext()) {
            numTS.add(alIter.next());
        }

        System.out.println("TreeSet: " + numTS);
    }
}

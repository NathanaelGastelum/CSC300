import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class PrioritizedDinos {

    public static void main(String[] args) {
        PriorityQueue<Dinosaur> dinoQueue = new PriorityQueue<>(new ComparatorDinosaur());
        Random randy = new Random(2);

        for (int i = 0; i < 10; i++) {
            Dinosaur dinosaur = new Dinosaur(randy.nextInt(100000) + 50000);
            dinoQueue.add(dinosaur);
        }

        while (!dinoQueue.isEmpty()) {
            System.out.println(dinoQueue.remove());
        }

        ArrayList<String> alPeop = new ArrayList<>();
        String [] peopArray = new String[alPeop.size()];
        peopArray = (String[]) alPeop.toArray();

    }
}
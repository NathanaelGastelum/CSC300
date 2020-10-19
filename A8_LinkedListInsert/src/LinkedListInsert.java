import java.util.*;

public class LinkedListInsert {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random r = new Random();

        for(int i = 0; i < 25; i++) {
            list.add(r.nextInt(101));
        }

        Collections.sort(list);

        System.out.println(list);

        ListIterator<Integer> li = list.listIterator();
        int sum = 0;
        while(li.hasNext()) {
            sum += li.next();
        }

        System.out.printf("Sum: %d \nAverage: %.2f \n", sum, sum/25.0);

        Collections.reverse(list);
        System.out.println(list);
    }
}
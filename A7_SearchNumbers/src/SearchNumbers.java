import java.util.*;
import java.util.stream.Collectors;

public class SearchNumbers {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(new Random().ints(50, 0, 51)
                .boxed().collect(Collectors.toList()));

        Collections.sort(list);

        System.out.println("The sorted ArrayList is " + list.toString());

        Scanner s = new Scanner(System.in);
        int searchElement = 0;
        while (searchElement > -1) {
            System.out.println("Please enter the value of the query between 0 and 50. Enter negative to exit: ");
            searchElement = s.nextInt();

            if (searchElement < 0)
                break;
            else if (list.contains(searchElement))
                System.out.printf("%d is found at index %d \n", searchElement, list.indexOf(searchElement));
            else
                System.out.printf("The value %d is not found \n", searchElement);
        }
    }
}

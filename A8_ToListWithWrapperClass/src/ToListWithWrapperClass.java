import java.util.Arrays;
import java.util.List;

public class ToListWithWrapperClass {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(array));

        List<Integer> list = Arrays.asList(array);
        System.out.println(list);

        array[2] = 7;
        System.out.println(list);
    }
}

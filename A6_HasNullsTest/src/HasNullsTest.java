import java.util.ArrayList;

public class HasNullsTest {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("test");
        list1.add(null);
        list1.add("testing");
        list1.add("123");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("test");
        list2.add("testing");
        list2.add("123");

        System.out.println(hasNulls(list1));
        System.out.println(hasNulls(list2));
    }

    public static boolean hasNulls(ArrayList<?> list) {
        return  list.contains(null);
    }
}

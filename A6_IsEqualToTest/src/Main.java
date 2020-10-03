import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Please enter 2 integers");
        int a = s.nextInt();
        int b = s.nextInt();
        s.nextLine();
        System.out.println(isEqualToTest(a, b));

        System.out.println("Please enter 2 doubles");
        double double1 = s.nextDouble();
        double double2 = s.nextDouble();
        s.nextLine();
        System.out.println(isEqualToTest(double1, double2));

        System.out.println("Please enter 2 words");
        String string1 = s.next();
        String string2 = s.next();
        s.nextLine();
        System.out.println(isEqualToTest(string1, string2));

        System.out.println("\nObject test: ");
        Object object1 = new Object();
        Object object2 = new Object();
        System.out.println(isEqualToTest(object1, object2));

        object2 = object1;
        System.out.println(isEqualToTest(object1, object2));
    }

    public static <T> boolean isEqualToTest(T a, T b) {
        return a.equals(b);
    }
}

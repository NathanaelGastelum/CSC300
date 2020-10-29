import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> set = new HashSet<>();
        getNames(set);
        searchNames(set);
        printNames(set);
    }

    public static void getNames(Set<String> set) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.print("What is the name of your input file of random names: ");
        Scanner input = new Scanner(new File(s.nextLine()));

        while (input.hasNext()) {
            set.add(input.next());
        }
    }

    public static void searchNames(Set<String> set) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a name to Search for, use 99 to terminate searching: ");
            String name = s.nextLine();

            if (name.equals("99")) break;
            else {
                if (set.contains(name))
                    System.out.println(name + " is found in set");
                else
                    System.out.println(name + " not found in set");
            }
        }
    }

    public static void printNames(Set<String> set) {
        for (String s : set) {
            System.out.println(s);
        }
    }
}

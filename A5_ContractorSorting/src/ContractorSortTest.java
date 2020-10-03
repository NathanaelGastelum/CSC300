import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ContractorSortTest {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the name of the input file with Contractor Data: ");
        Scanner input = new Scanner(new File(keyboard.nextLine()));

        ArrayList<Contractor> contractors = new ArrayList<>();

        while (input.hasNextLine()) {
            String[] contractor = input.nextLine().split(" ");
            contractors.add(new Contractor(contractor[0], contractor[1], Integer.parseInt(contractor[2])));
        }
        input.close();

        Collections.sort(contractors, new ComparatorSortName());
        System.out.println("List Sorted By Contractor Name");
        for (Contractor c : contractors) {
            System.out.println(c.toString());
        }
        System.out.println();

        Collections.sort(contractors, new ComparatorSortLocation());
        System.out.println("List Sorted By Location");
        for (Contractor c : contractors) {
            System.out.println(c.toString());
        }
        System.out.println();

        Collections.sort(contractors, new ComparatorSortOwnerID());
        System.out.println("List Sorted By OwnerID");
        for (Contractor c : contractors) {
            System.out.println(c.toString());
        }
        System.out.println();

        Collections.sort(contractors, new ComparatorMultiSort());
        System.out.println("List Sorted By MultiSorted");
        for (Contractor c : contractors) {
            System.out.println(c.toString());
        }
    }
}

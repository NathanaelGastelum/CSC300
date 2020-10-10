import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Sorting {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the name of the input file: ");
        Scanner input = new Scanner(new File(s.nextLine()));
        System.out.println("Please enter the name of the output file: ");
        String outFile = s.nextLine();
        PrintWriter output = new PrintWriter(outFile);

        ArrayList<String> names = new ArrayList<>(input.tokens().collect(Collectors.toList()));
        Collections.sort(names);
        Iterator<String> iterator = names.iterator();

        output.println("Ascending List");
        while (iterator.hasNext()) {
            output.println(iterator.next());
        }

        ListIterator<String> listIterator = names.listIterator(names.size());

        output.println("\nDescending List");
        while (listIterator.hasPrevious()) {
            output.println(listIterator.previous());
        }

        output.println("\nFirst alphabetized element is " + Collections.min(names));
        output.println("\nLast alphabetized element is " + Collections.max(names));

        output.close();
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueUserDefinedObjectExample {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the name of the input file: ");
        Scanner input = new Scanner(new File(s.nextLine()));
        System.out.println("Please enter the name of the output file: ");
        String outFile = s.nextLine();
        PrintWriter output = new PrintWriter(outFile);

        PriorityQueue<Employee> pq = new PriorityQueue<>();
        while (input.hasNext()) {
            pq.add(new Employee(input.next(), input.nextDouble()));
        }

        output.printf("%8s\t%s \n", "NAME", "SALARY");
        while (!pq.isEmpty()) {
            Employee temp = pq.poll();
            output.printf("%8s\t$%.2f \n", temp.getName(), temp.getSalary());
        }

        output.close();
    }
}

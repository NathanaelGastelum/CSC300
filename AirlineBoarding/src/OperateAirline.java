import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OperateAirline {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Flight> flightList = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        String flightName;
        int seed;
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter the Flight Name: ");
            flightName = s.nextLine();
            System.out.println("Please enter an integer seed from 1 to 50: ");
            seed = s.nextInt();
            s.nextLine();

            flightList.add(new Flight(flightName, seed));
        }

        System.out.println("Please enter the name of the output file: ");
        String outFile = s.nextLine();
        PrintWriter output = new PrintWriter(outFile);

        for (Flight f : flightList) {
            f.sellSeats();
            f.lineUpCall();
            f.boarding(output);
            output.print("\n\n");
        }
        output.close();
    }
}

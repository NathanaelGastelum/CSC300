import java.util.Scanner;
public class TestPrintQueueSimulation
{
    public static void main(String [] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.print("Please enter the number of printers for the simulation: ");
        int printerCount = s.nextInt();

        System.out.print("Please enter the number of printer jobs for the simulation: ");
        int jobCount = s.nextInt();

        System.out.print("Please enter a random number seed for the simulation: ");
        int seed = s.nextInt();

        PrintQueueSimulation pqSim = new PrintQueueSimulation(printerCount, jobCount, seed);
        pqSim.simulate();
    }
}
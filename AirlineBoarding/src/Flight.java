import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class Flight {
    public String flightName;
    private int seats;
    private int seatsSold;
    private Random randy;
    private LinkedList<Passenger> passBooked = new LinkedList<>();
    private PriorityQueue<Passenger> boardingQueue = new PriorityQueue<>(new PassengerComparator());

    public Flight(String flightName, int seed) {
        setFlightName(flightName);
        randy = new Random(seed);
        setSeats();
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public void setSeats() {
        this.seats = randy.nextInt(75) + 75;
    }

    public void sellSeats() {
        seatsSold = seats/2 + randy.nextInt(seats/2 + 1);

        for (int i = 0; i < seatsSold; i++) {
            int rolld4 = randy.nextInt(5);
            if (rolld4 == 0) {
                passBooked.add(new FirstClassPassenger());
            }
            else passBooked.add(new CoachPassenger());
        }
    }

    public void lineUpCall() {
        boardingQueue.addAll(passBooked);
    }

    public void boarding(PrintWriter outputWriter) {
        outputWriter.printf("The boarding order for Flight %s with %d seats and %d seats sold is: \n", flightName, seats, seatsSold);

        for (int i = 0; !boardingQueue.isEmpty(); i++) {
            if (i == 3) {
                outputWriter.println();
                i = -1;
            }
            else {
                outputWriter.printf("%-15s\t\t", boardingQueue.remove());
            }
        }
    }
}
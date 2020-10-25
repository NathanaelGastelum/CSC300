import java.util.Comparator;

public class PassengerComparator implements Comparator<Passenger> {
    @Override
    public int compare(Passenger p1, Passenger p2) {

        if(p1.getTicketClass().equals(p2.getTicketClass())) {
            return p1.getTicketNumber() - p2.getTicketNumber();
        }
        else if (p1.getTicketClass().equals("First") && p2.getTicketClass().equals("Coach")) {
            return -1;
        }
        else return 1;
    }
}

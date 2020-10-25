public class Passenger {
    private String passengerID;
    private String ticketClass;
    private int ticketNumber;
    static int ticketCounter = 0;

    public Passenger(String ticketClass) {
        setTicketNumber();
        setTicketClass(ticketClass);
        setPassengerID();

    }

    @Override
    public String toString() {
        return getPassengerID();
    }

    public void setTicketNumber() {
        ticketCounter++;
        this.ticketNumber = ticketCounter;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public void setPassengerID() {
        this.passengerID = String.format("PID_%s %d", ticketClass, ticketNumber);
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}

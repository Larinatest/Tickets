import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {
        int t1FlightDuration = t1.getTimeTo() - t1.getTimeFrom();
        int t2FlightDuration = t2.getTimeTo() - t2.getTimeFrom();
        return Integer.compare(t1FlightDuration, t2FlightDuration);
    }
}

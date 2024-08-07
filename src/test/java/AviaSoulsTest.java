import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AviaSoulsTest {

    @Test
    public void testCompareTo() {
        Ticket ticket1 = new Ticket("NYC", "LA", 300, 1400, 1700);
        Ticket ticket2 = new Ticket("NYC", "LA", 200, 1400, 1700);
        assertTrue(ticket2.compareTo(ticket1) < 0);
        assertTrue(ticket1.compareTo(ticket2) > 0);
    }

    @Test
    public void testSearchAndSortByPrice() {
        AviaSouls manager = new AviaSouls();
        manager.add(new Ticket("NYC", "LA", 300, 1400, 1700));
        manager.add(new Ticket("NYC", "LA", 200, 1400, 1700));
        manager.add(new Ticket("NYC", "LA", 400, 1400, 1700));

        Ticket[] result = manager.search("NYC", "LA");

        Ticket[] expected = {
                new Ticket("NYC", "LA", 200, 1400, 1700),
                new Ticket("NYC", "LA", 300, 1400, 1700),
                new Ticket("NYC", "LA", 400, 1400, 1700)
        };

        assertArrayEquals(expected, result);
    }

    @Test
    public void testTicketTimeComparator() {
        Ticket ticket1 = new Ticket("NYC", "LA", 300, 1400, 1700);
        Ticket ticket2 = new Ticket("NYC", "LA", 300, 1400, 1800);
        TicketTimeComparator comparator = new TicketTimeComparator();

        assertTrue(comparator.compare(ticket1, ticket2) < 0);
        assertTrue(comparator.compare(ticket2, ticket1) > 0);
    }

    @Test
    public void testSearchAndSortByTime() {
        AviaSouls manager = new AviaSouls();
        manager.add(new Ticket("NYC", "LA", 300, 1400, 1700));
        manager.add(new Ticket("NYC", "LA", 200, 1400, 1800));
        manager.add(new Ticket("NYC", "LA", 400, 1400, 1600));

        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] result = manager.searchAndSortBy("NYC", "LA", comparator);

        Ticket[] expected = {
                new Ticket("NYC", "LA", 400, 1400, 1600), // Shortest flight time
                new Ticket("NYC", "LA", 300, 1400, 1700),
                new Ticket("NYC", "LA", 200, 1400, 1800)  // Longest flight time
        };

        assertArrayEquals(expected, result);
    }
}

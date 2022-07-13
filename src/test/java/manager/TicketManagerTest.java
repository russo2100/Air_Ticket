package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {


    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 200, "KUF", "AKX", 130);
    Ticket ticket2 = new Ticket(2, 800, "KUF", "AER", 480);
    Ticket ticket3 = new Ticket(3, 300, "VOZ", "KUF", 45);
    Ticket ticket4 = new Ticket(4, 400, "KUF", "AKX", 90);
    Ticket ticket5 = new Ticket(5, 550, "ARH", "AER", 180);
    Ticket ticket6 = new Ticket(6, 650, "KUF", "AKX", 200);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldSearchOneTicket() {
        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.searchTickets("KUF", "AER");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSeveralTickets() {
        Ticket[] expected = {ticket1, ticket4, ticket6};
        Ticket[] actual = manager.searchTickets("KUF", "AKX");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchTickets("VKO", "KZN");

        assertArrayEquals(expected, actual);
    }
}

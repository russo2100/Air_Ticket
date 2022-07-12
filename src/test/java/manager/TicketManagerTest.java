package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {






        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 200, "KUF", "AZN", 130);
    Ticket ticket2 = new Ticket(2, 800, "VKO", "AKX", 480);
    Ticket ticket3 = new Ticket(3, 300, "VOZ", "AYT", 45);
    Ticket ticket4 = new Ticket(4, 400, "AER", "AZN", 90);
    Ticket ticket5 = new Ticket(5, 550, "ARH", "AER", 180);
    Ticket ticket6 = new Ticket(6, 650, "TLV", "AZN", 200);

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
            Ticket[] actual = manager.searchTickets("VKO", "AKX");

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldSearchSeveralTickets() {
            Ticket[] expected = {ticket1};
            Ticket[] actual = manager.searchTickets("KUF", "AZN");

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldNotSearchTicket() {
            Ticket[] expected = {};
            Ticket[] actual = manager.searchTickets("VKO", "KZN");

            assertArrayEquals(expected, actual);
        }
    }

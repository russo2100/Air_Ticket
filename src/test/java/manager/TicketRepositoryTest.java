package manager;

import exception.AlreadyExistsException;
import exception.NotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 200, "KUF", "ABA", 130);
    Ticket ticket2 = new Ticket(2, 800, "VKO", "AKX", 480);
    Ticket ticket3 = new Ticket(3, 300, "VOZ", "AYT", 45);
    Ticket ticket4 = new Ticket(4, 400, "AER", "SVO", 90);
    Ticket ticket5 = new Ticket(5, 550, "ARH", "AER", 180);
    Ticket ticket6 = new Ticket(6, 650, "TLV", "AZN", 200);

    @Test
    public void emptyRepo() {
        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneTicket() {
        repo.save(ticket3);

        Ticket[] expected = {ticket3};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveSeveralTickets() {
        repo.save(ticket1);
        repo.save(ticket3);
        repo.save(ticket5);

        Ticket[] expected = {ticket1, ticket3, ticket5};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(ticket5);
        repo.save(ticket3);
        repo.save(ticket2);
        repo.removeById(2);

        Ticket[] expected = {ticket5, ticket3};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void throwsAnExceptionIdNotFound() {
        repo.save(ticket2);
        repo.save(ticket5);
        repo.save(ticket3);


        assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }

    @Test
    public void shouldThrowExceptionThePreservationProductExists() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);


        assertThrows(AlreadyExistsException.class, () -> {
            repo.save(ticket2);
        });
    }
}

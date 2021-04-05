package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}

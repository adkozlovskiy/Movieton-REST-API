package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    @Query("SELECT * FROM tickets WHERE user_id = :user_id ORDER BY buy_date DESC")
    List<Ticket> findTicketsByUserId(@Param("user_id") Long userId);

}

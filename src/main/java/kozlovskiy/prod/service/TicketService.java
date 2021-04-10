package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.Ticket;
import kozlovskiy.prod.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    public List<Ticket> findTicketsByUserId(Long id) {
        return ticketRepo.findTicketsByUserId(id);
    }

    public List<Ticket> findTicketsBySessionId(Long id) {
        return ticketRepo.findTicketsBySessionId(id);
    }
}

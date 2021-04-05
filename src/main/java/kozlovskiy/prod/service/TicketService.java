package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.Ticket;
import kozlovskiy.prod.exceptions.NotFoundException;
import kozlovskiy.prod.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    public List<Ticket> findTickets() {
        return ticketRepo.findAll();
    }

    public Ticket findTicketById(Long id) {
        return ticketRepo.findById(id).orElseThrow(NotFoundException::new);
    }

}

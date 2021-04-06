package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Ticket;
import kozlovskiy.prod.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketsController {

    @Autowired
    private TicketService service;

    @GetMapping("?")
    private List<Ticket> getTicketsByUserId(@RequestParam("user_id") Long userId) {
        return service.findTicketsByUserId(userId);
    }
}

package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Ticket;
import kozlovskiy.prod.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
public class TicketsController {

    @Autowired
    private TicketService service;

    @GetMapping("/get")
    @ResponseBody
    private ResponseEntity<List<Ticket>> getTicketsByUserId(@RequestParam("user_id") Long userId) {
        List<Ticket> tickets = service.findTicketsByUserId(userId);
        return tickets != null && !tickets.isEmpty()
                ? new ResponseEntity<>(tickets, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

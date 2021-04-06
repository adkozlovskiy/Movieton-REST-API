package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Ticket;
import kozlovskiy.prod.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
public class TicketsController {

    @Autowired
    private TicketService service;

    @GetMapping("/get")
    @ResponseBody
    private List<Ticket> getTicketsByUserId(@RequestParam("user_id") Long userId) {
        return service.findTicketsByUserId(userId);
    }
}

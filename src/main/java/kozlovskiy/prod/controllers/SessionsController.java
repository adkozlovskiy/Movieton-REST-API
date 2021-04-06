package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Session;
import kozlovskiy.prod.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sessions")
public class SessionsController {

    @Autowired
    private SessionService service;

    @GetMapping("?")
    @ResponseBody
    private List<Session> getSessionsByMovieId(@RequestParam("movie_id") Long movieId) {
        return service.getSessionsByMovieId(movieId);
    }

}

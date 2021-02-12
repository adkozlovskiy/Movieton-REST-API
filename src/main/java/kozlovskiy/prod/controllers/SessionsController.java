package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Session;
import kozlovskiy.prod.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sessions")
public class SessionsController {

    @Autowired
    private SessionService service;

    @GetMapping("/get/{movie_id}")
    List<Session> getSessionsByMovieId(@PathVariable("movie_id") int movieId) {
        return service.getSessionsByMovieId(movieId);
    }

}

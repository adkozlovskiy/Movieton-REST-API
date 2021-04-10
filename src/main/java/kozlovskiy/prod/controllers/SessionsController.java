package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Session;
import kozlovskiy.prod.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sessions")
public class SessionsController {

    @Autowired
    private SessionService service;

    @GetMapping("/on_movie")
    @ResponseBody
    private List<Session> getSessionsByMovieId(@RequestParam("movie_id") Long movieId) {
        return service.getSessionsByMovieId(movieId);
    }

    @GetMapping
    @ResponseBody
    private ResponseEntity<Session> getSession(@RequestParam("session_id") Long sessionId) {
        Session body = service.getSession(sessionId);
        return body != null
                ? new ResponseEntity<>(body, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

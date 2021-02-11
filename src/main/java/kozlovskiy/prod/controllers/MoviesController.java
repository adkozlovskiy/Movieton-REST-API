package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Movie;
import kozlovskiy.prod.exceptions.NotFoundException;
import kozlovskiy.prod.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MoviesController {

    @Autowired
    private MoviesService service;

    @GetMapping
    List<Movie> getMovies() {
        return service.getMovies();
    }

    @GetMapping("/categories/{category}")
    HashMap<String, String> getMovies(@PathVariable String category) {
        return null;
    }

    /* @GetMapping("/get/{title}")
    Movie getMovie(@PathVariable String title) {
        return service.getMovieByTitle(title);
    } */

    @GetMapping("/get/{id}")
    Movie getMovie(@PathVariable int id) {
        return service.getMovieById(id);
    }

}

package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Movie;
import kozlovskiy.prod.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    List<Movie> getMovies(@PathVariable String category) {
        return service.getMoviesByCategory(category);
    }

    @GetMapping("/get/{id}")
    Movie getMovie(@PathVariable int id) {
        return service.getMovieById(id);
    }

}

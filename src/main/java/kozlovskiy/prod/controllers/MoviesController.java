package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Movie;
import kozlovskiy.prod.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MoviesController {

    @Autowired
    private MoviesService service;

    @GetMapping
    private List<Movie> getMovies() {
        return service.getMovies();
    }

    @GetMapping("?")
    @ResponseBody
    private Movie getMovie(@RequestParam(name = "user_id") Long userId) {
        return service.getMovieById(userId);
    }
}

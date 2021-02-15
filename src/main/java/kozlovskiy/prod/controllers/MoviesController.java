package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Movie;
import kozlovskiy.prod.entities.MovieCategory;
import kozlovskiy.prod.service.MovieCategoryService;
import kozlovskiy.prod.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MoviesController {

    @Autowired
    private MoviesService service;

    @Autowired
    private MovieCategoryService movieCategoryService;

    @GetMapping
    List<Movie> getMovies() {
        return service.getMovies();
    }

    @GetMapping("/get/{id}")
    Movie getMovie(@PathVariable int id) {
        return service.getMovieById(id);
    }

    @GetMapping("/categories/{categoryId}")
    List<MovieCategory> findAllMoviesByCategoryId(@PathVariable int categoryId) {
        return movieCategoryService.findAllMoviesByCategoryId(categoryId);
    }

}

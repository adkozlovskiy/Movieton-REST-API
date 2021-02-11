package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.Movie;
import kozlovskiy.prod.exceptions.NotFoundException;
import kozlovskiy.prod.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MovieRepo movieRepo;

    /* public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    } */

    /* public List<Movie> saveMovies(List<Movie> movies) {
        return movieRepo.saveAll(movies);
    } */

    public List<Movie> getMovies() {
        return movieRepo.findAll();
    }

    public Movie getMovieById(int id) {
        return movieRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    /* public Movie getMovieByTitle(String title) {
        return movieRepo.findByTitle(title);
    } */

}

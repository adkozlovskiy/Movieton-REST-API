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

    public List<Movie> getMovies() {
        return movieRepo.findAll();
    }

    public List<Movie> getMoviesByCategory(String category) {
        return movieRepo.findByCategory(category);
    }

    public Movie getMovieById(int id) {
        return movieRepo.findById(id).orElseThrow(NotFoundException::new);
    }

}

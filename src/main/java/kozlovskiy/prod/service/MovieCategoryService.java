package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.MovieCategory;
import kozlovskiy.prod.repo.MovieCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCategoryService {

    @Autowired
    private MovieCategoryRepo movieCategoryRepo;

    public List<MovieCategory> findAllMoviesByCategoryId(int categoryId) {
        return movieCategoryRepo.findAllMoviesByCategoryId(categoryId);
    }
}



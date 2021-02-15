package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCategoryRepo extends JpaRepository<MovieCategory, Integer> {

    List<MovieCategory> findAllMoviesByCategoryId(int categoryId);
}

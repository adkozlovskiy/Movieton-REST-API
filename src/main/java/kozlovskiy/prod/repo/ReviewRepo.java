package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

    List<Review> findAllReviewsByMovieId(int movieId);
}

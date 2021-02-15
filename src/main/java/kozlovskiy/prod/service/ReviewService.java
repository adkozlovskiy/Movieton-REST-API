package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.Review;
import kozlovskiy.prod.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    public List<Review> findAllReviewsByMovieId(int movieId) {
        return reviewRepo.findAllReviewsByMovieId(movieId);
    }

}

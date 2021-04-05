package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepo extends JpaRepository<Session, Long> {

    @Query(value = "SELECT * FROM sessions WHERE movie_id = :movieId", nativeQuery = true)
    List<Session> findByMovieId(@Param("movieId") int movieId);
}

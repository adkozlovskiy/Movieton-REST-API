package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepo extends JpaRepository<Session, Long> {

    @Query(value = "SELECT * FROM sessions WHERE movie_id = :movieId AND session_date > CURRENT_DATE() ORDER BY session_date", nativeQuery = true)
    List<Session> findByMovieId(@Param("movieId") Long movieId);

    @Query(value = "SELECT * FROM sessions WHERE id = :session_id AND session_date > CURRENT_DATE()", nativeQuery = true)
    Session getSession(@Param("session_id") Long sessionId);
}

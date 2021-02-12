package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepo extends JpaRepository<Session, Integer> {

    List<Session> findByMovieId(int movieId);
}

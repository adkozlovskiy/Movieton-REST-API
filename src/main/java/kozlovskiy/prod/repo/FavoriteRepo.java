package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite, Integer> {

    List<Favorite> findByUserId(int userId);
}

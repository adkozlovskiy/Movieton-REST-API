package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.BarMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepo extends JpaRepository<BarMenu, Integer> {

}

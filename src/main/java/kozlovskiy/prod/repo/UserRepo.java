package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}

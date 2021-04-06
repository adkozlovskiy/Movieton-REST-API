package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthRepo extends JpaRepository<User, Long> {

    @Query("SELECT * FROM users WHERE login = :login")
    User findByLogin(@Param("login") String login);
}

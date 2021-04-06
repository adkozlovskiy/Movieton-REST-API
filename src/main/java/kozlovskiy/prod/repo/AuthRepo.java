package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE login = :login OR email = :email OR phone = :phone", nativeQuery = true)
    User findByLogin(@Param("login") String login, @Param("email") String email, @Param("phone") String phone);
}

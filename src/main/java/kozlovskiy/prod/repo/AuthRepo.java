package kozlovskiy.prod.repo;

import kozlovskiy.prod.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE nickname = :nickname OR email = :email", nativeQuery = true)
    User findByLogin(@Param("nickname") String nickname, @Param("email") String email);

}

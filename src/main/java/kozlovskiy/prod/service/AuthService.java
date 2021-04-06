package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.User;
import kozlovskiy.prod.repo.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepo authRepo;

    public User registerUser(User user) {
        try {
            return authRepo.save(user);

        } catch (Exception e) {
            return null;
        }
    }

    public User authorizeUser(User user) {
        return authRepo.findByLogin(user.getLogin());
    }
}

package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.User;
import kozlovskiy.prod.repo.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepo authRepo;

    public User registerUser(User regData) {
        try {
            return authRepo.save(regData);

        } catch (Exception e) {
            return null;
        }
    }

    public User authorizeUser(User ld) {
        User u = authRepo.findByLogin(ld.getLogin(), ld.getEmail(), ld.getPhone());

        if (u != null) {
            if ((u.getPassword() + u.getSalt()).equals(ld.getPassword() + ld.getSalt()))
                return u;

            else return null;
        }

        return null;
    }
}

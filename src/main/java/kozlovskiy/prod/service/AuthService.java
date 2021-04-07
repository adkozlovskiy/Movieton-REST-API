package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.User;
import kozlovskiy.prod.repo.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.tomcat.util.security.MD5Encoder.encode;

@Service
public class AuthService {

    @Autowired
    private AuthRepo authRepo;

    /**
     * @param rd is register data such as password, salt, username
     * @return created user if successful registered, else - null
     */

    public User registerUser(User rd) {
        try {
            String encodedPass = getHashedPassword(rd.getPassword(), rd.getSalt());
            rd.setPassword(encodedPass);
            return authRepo.save(rd);

        } catch (Exception e) {
            return null;
        }
    }

    public User authorizeUser(User ld) {
        User u = authRepo.findByLogin(ld.getLogin(), ld.getEmail());

        if (u != null) {
            if (u.getPassword().equals(getHashedPassword(ld.getPassword(), u.getSalt())))
                return u;

            else return null;
        }

        return null;
    }

    private String getHashedPassword(String pass, String salt) {
        return encode((pass + salt).getBytes());
    }
}

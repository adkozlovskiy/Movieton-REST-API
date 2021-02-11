package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.User;
import kozlovskiy.prod.exceptions.NotFoundException;
import kozlovskiy.prod.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(NotFoundException::new);
    }
}

package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.User;
import kozlovskiy.prod.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping
    List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }
}

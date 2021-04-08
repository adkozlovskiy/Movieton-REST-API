package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.User;
import kozlovskiy.prod.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("reg")
    public User registerUser(@RequestBody User user) {
        return service.registerUser(user);
    }

    @PostMapping("auth")
    public ResponseEntity<User> authorizeUser(@RequestBody User user) {
        User body = service.authorizeUser(user);

        return body != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

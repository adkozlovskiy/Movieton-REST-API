package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping(name = "favorites")
public class FavoritesController {

    @PostMapping
    ArrayList<HashMap<String, String>> getUserFavorites(@RequestBody User user) {
        return null;
    }
}

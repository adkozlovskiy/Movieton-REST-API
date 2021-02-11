package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.User;
import org.springframework.web.bind.annotation.*;

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

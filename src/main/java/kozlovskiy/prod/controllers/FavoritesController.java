package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Favorite;
import kozlovskiy.prod.entities.User;
import kozlovskiy.prod.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorites")
public class FavoritesController {

    @Autowired
    private FavoriteService service;

    @GetMapping("/get/{user_id}")
    List<Favorite> getUserFavorites(@PathVariable("user_id") int userId) {
        return service.getUserFavorites(userId);
    }
}

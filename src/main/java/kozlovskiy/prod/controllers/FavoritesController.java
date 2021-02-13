package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Favorite;
import kozlovskiy.prod.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Favorite;
import kozlovskiy.prod.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/favorites")
public class FavoritesController {

    @Autowired
    private FavoriteService service;

    @GetMapping("?")
    @ResponseBody
    private List<Favorite> getUserFavorites(@RequestParam(name = "user_id") Long userId) {
        return service.getUserFavorites(userId);
    }
}

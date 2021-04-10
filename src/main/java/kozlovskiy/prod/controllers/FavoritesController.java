package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Favorite;
import kozlovskiy.prod.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/favorites")
public class FavoritesController {

    @Autowired
    private FavoriteService service;

    @GetMapping("/get")
    @ResponseBody
    private ResponseEntity<List<Favorite>> getUserFavorites(@RequestParam(name = "user_id") Long userId) {
        List<Favorite> body = service.getUserFavorites(userId);

        return body != null && !body.isEmpty()
                ? new ResponseEntity<>(body, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    private ResponseEntity<Favorite> postUserFavorite(@RequestBody Favorite favorite) {
        Favorite body = service.postUserFavorite(favorite);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
}

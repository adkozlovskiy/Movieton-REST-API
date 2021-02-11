package kozlovskiy.prod.controllers;

import kozlovskiy.prod.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("movies")
public class MoviesController {

    private ArrayList<HashMap<String, String>> films = new ArrayList<>() {{
        add(new HashMap<>() {{
            put("id", "0");
            put("title", "Джуманджи");
            put("cost", "1400");
        }});

        add(new HashMap<>() {{
            put("id", "1");
            put("title", "Джуманджи 2");
            put("cost", "1600");
        }});
    }};

    @GetMapping
    ArrayList<HashMap<String, String>> getMovies() {
        return films;
    }

    @GetMapping("{category}")
    HashMap<String, String> getMovies(@PathVariable String category) {
        return films.stream().filter(film -> film.get("category").equals(category))
                .findAny()
                .orElseThrow(NotFoundException::new);
    }

    @GetMapping("{title}")
    HashMap<String, String> getMovie(@PathVariable String title) {
        return films.stream().filter(film -> film.get("title").equals(title))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @GetMapping("{id}")
    HashMap<String, String> getMovie(@PathVariable int id) {
        return films.stream().filter(film -> film.get("id").equals(Integer.toString(id)))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

}

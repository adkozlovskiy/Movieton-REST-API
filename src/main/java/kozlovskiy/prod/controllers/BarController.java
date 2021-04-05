package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Menu;
import kozlovskiy.prod.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/menu")
public class BarController {

    @Autowired
    private BarService service;

    @GetMapping
    private List<Menu> getMenu() {
        return service.getMenu();
    }
}

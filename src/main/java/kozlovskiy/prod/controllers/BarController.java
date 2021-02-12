package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.BarMenu;
import kozlovskiy.prod.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class BarController {

    @Autowired
    private BarService service;

    @GetMapping
    List<BarMenu> getMenu() {
        return service.getMenu();
    }

    @GetMapping("/get/{id}")
    BarMenu getMenuItem(@PathVariable int id) {
        return service.getMenuItemById(id);
    }
}

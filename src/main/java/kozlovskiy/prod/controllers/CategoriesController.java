package kozlovskiy.prod.controllers;

import kozlovskiy.prod.entities.Category;
import kozlovskiy.prod.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoriesController {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping
    List<Category> getCategories() {
        return categoryRepo.findAll();
    }

}

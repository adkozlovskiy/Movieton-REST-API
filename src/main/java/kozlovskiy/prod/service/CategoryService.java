package kozlovskiy.prod.service;

import kozlovskiy.prod.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


}

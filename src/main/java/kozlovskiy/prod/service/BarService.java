package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.BarMenu;
import kozlovskiy.prod.exceptions.NotFoundException;
import kozlovskiy.prod.repo.BarRepo;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarService {

    @Autowired
    private BarRepo barRepo;

    public List<BarMenu> getMenu() {
        return barRepo.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    public BarMenu getMenuItemById(int id) {
        return barRepo.findById(id).orElseThrow(NotFoundException::new);
    }
}

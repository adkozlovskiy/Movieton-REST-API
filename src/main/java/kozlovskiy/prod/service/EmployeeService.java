package kozlovskiy.prod.service;

import kozlovskiy.prod.entities.Employee;
import kozlovskiy.prod.exceptions.NotFoundException;
import kozlovskiy.prod.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).orElseThrow(NotFoundException::new);
    }
}

package com.priacc.ieap.employee_service.service;

import com.priacc.ieap.employee_service.repository.EmployeeRepository;
import com.priacc.ieap.employee_service.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public Optional<Employee> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}

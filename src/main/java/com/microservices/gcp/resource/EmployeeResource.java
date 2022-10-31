package com.microservices.gcp.resource;

import com.microservices.gcp.model.Employee;
import com.microservices.gcp.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/v1")
public class EmployeeResource {

    private final EmployeeRepository employeeRepository;

    public EmployeeResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        this.employeeRepository.findAll().forEach(employees::add);
        if(employees.size() == 0) {
            return new ResponseEntity<>(employees,HttpStatus.OK);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {

        Optional<Employee> employee  = this.employeeRepository.findById(Long.parseLong(id));
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
    }
}

package com.alexb.empstore.service;

import com.alexb.empstore.exception.EmpNotFoundException;
import com.alexb.empstore.model.Employee;
import com.alexb.empstore.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired
    EmpRepository empRepository;

    public Employee getEmployee(String id) {
        return empRepository.findById(id).orElseThrow(EmpNotFoundException::new);
    }

    public void updateEmployee(String id, Employee employee) {
        Employee emp = empRepository.findById(id).orElseThrow(EmpNotFoundException::new);
        emp.setDepartment(employee.getDepartment());
        emp.setJob(employee.getJob());
        emp.setName(emp.getName());
        emp.setSalary(emp.getSalary());
        empRepository.save(emp);
    }
}

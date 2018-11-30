package com.alexb.empstore.repository;

import com.alexb.empstore.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepository extends MongoRepository<Employee, String> {

     Employee findByName(String name);
}

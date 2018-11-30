package com.alexb.empstore;

import com.alexb.empstore.model.Employee;
import com.alexb.empstore.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EmpStoreApplication {

    @Autowired
    EmpRepository empRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmpStoreApplication.class, args);
    }

    @Bean
    CommandLineRunner mongoInit() {
        return args -> {
            empRepository.deleteAll();
            List<Employee> employees = Arrays.asList(new Employee("1", "CLARK", "DEVELOPER", "DEVELOPMENT", 2000.0),
                    new Employee("2", "MILLER", "TESTER", "TESTING", 2000.0),
                    new Employee("3", "JOE", "MANAGER", "MANAGEMENT", 2000.0));
            empRepository.saveAll(employees);
        };
    }
}

package com.alexb.empapi.controller;

import com.alexb.empapi.model.Employee;
import com.alexb.empapi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    EmpService empService;

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable String id) {
        return ResponseEntity.ok(empService.getEmployee(id));
    }

    @PutMapping("/{id}")
    ResponseEntity updateById(@PathVariable String id, @RequestBody Employee employee) {
        empService.updateEmployee(id, employee);
        return ResponseEntity.noContent().build();
    }
}

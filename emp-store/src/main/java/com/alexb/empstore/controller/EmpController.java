package com.alexb.empstore.controller;

import com.alexb.empstore.model.Employee;
import com.alexb.empstore.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable String id) {
        return ResponseEntity.ok(empService.getEmployee(id));
    }

    @PutMapping("/{id}")
    ResponseEntity updateById(@PathVariable String id, @RequestBody Employee employee){
        empService.updateEmployee(id,employee);
        return ResponseEntity.noContent().build();
    }
}
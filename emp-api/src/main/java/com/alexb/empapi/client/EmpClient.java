package com.alexb.empapi.client;

import com.alexb.empapi.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "emp-store")
public interface EmpClient {
    @GetMapping("/{id}")
    Employee getById(@PathVariable(value = "id") String id);

    @PutMapping("/{id}")
    void updateById(@PathVariable(value = "id") String id, @RequestBody Employee employee);
}

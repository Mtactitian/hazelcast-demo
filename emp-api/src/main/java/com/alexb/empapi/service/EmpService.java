package com.alexb.empapi.service;

import com.alexb.empapi.client.EmpClient;
import com.alexb.empapi.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmpService {

    @Autowired
    EmpClient empClient;

    @Cacheable(cacheNames = "emp")
     public Employee getEmployee(String id) {
        log.info("Getting emp by id: {}", id);
        return empClient.getById(id);
    }

    @CacheEvict(cacheNames = "emp")
    public void updateEmployee(String id, Employee employee){
        empClient.updateById(id,employee);
    }
}

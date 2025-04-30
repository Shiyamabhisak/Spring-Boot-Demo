package com.luv2codeinspring.restcruddemo.dao;

import com.luv2codeinspring.restcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findTheEmployeeById(int id);
    // No additional methods are needed as JpaRepository provides all the necessary CRUD operations
}

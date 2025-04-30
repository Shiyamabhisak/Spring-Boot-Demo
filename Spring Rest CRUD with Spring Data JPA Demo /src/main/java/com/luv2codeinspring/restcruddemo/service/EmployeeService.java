package com.luv2codeinspring.restcruddemo.service;

import com.luv2codeinspring.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee findEmployeeById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployeeById(int id);
}

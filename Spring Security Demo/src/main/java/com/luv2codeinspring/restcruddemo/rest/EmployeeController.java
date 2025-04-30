package com.luv2codeinspring.restcruddemo.rest;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2codeinspring.restcruddemo.entity.Employee;
import com.luv2codeinspring.restcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee partialUpdateEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayLoad) throws JsonMappingException {
        Employee existingEmployee = employeeService.findEmployeeById(employeeId);
        if (existingEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        if(patchPayLoad.containsKey("id")){
            throw new RuntimeException("Employee id cannot be updated - " + employeeId);
        }

        Employee updatedEmployee = apply(existingEmployee, patchPayLoad);

        return employeeService.saveEmployee(updatedEmployee);
    }

    private Employee apply(Employee employee, Map<String, Object> patchPayLoad) throws JsonMappingException {
        // Convert the patch payload to a JSON string
        ObjectNode patchNode = objectMapper.convertValue(patchPayLoad, ObjectNode.class);

        // Convert the employee object to a JSON string
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        // Merge the patch payload into the employee object
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}

package com.example.springboot_jooq_employee_crud.dto;

import java.time.LocalDate;

public record EmployeeDto(Integer id, String firstName, String lastName, String email, LocalDate hireDate) {}

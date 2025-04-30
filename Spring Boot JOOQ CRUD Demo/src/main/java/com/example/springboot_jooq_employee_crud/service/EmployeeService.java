package com.example.springboot_jooq_employee_crud.service;

import com.example.springboot_jooq_employee_crud.dto.EmployeeDto;
import com.example.springboot_jooq_employee_crud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public EmployeeDto create(EmployeeDto dto) {
        var record = repo.create(new EmployeeRecord()
                .setFirstName(dto.firstName())
                .setLastName(dto.lastName())
                .setEmail(dto.email())
                .setHireDate(dto.hireDate()));
        return new EmployeeDto(record.getId(), record.getFirstName(), record.getLastName(), record.getEmail(), record.getHireDate());
    }

    public List<EmployeeDto> list() {
        return repo.findAll().stream()
                .map(r -> new EmployeeDto(r.getId(), r.getFirstName(), r.getLastName(), r.getEmail(), r.getHireDate()))
                .collect(Collectors.toList());
    }

    public EmployeeDto get(int id) {
        var r = repo.findById(id);
        return new EmployeeDto(r.getId(), r.getFirstName(), r.getLastName(), r.getEmail(), r.getHireDate());
    }

    public void update(EmployeeDto dto) {
        repo.update(new EmployeeRecord()
                .setId(dto.id())
                .setFirstName(dto.firstName())
                .setLastName(dto.lastName())
                .setEmail(dto.email())
                .setHireDate(dto.hireDate()));
    }

    public void delete(int id) {
        repo.delete(id);
    }
}

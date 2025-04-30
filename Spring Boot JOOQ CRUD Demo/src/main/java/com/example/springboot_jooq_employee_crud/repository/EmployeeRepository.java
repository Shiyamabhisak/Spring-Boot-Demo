package com.example.springboot_jooq_employee_crud.repository;

import com.example.springboot_jooq_employee_crud.jooq.tables.Employee;
import com.example.springboot_jooq_employee_crud.jooq.tables.records.EmployeeRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final DSLContext dsl;
    private final Employee e = Employee.EMPLOYEE;

    public EmployeeRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public EmployeeRecord create(EmployeeRecord record) {
        return dsl.insertInto(e)
                .set(record)
                .returning()
                .fetchOne();
    }

    public List<EmployeeRecord> findAll() {
        return dsl.selectFrom(e).fetch();
    }

    public EmployeeRecord findById(int id) {
        return dsl.selectFrom(e)
                .where(e.ID.eq(id))
                .fetchOne();
    }

    public int update(EmployeeRecord record) {
        return dsl.update(e)
                .set(record)
                .where(e.ID.eq(record.getId()))
                .execute();
    }

    public int delete(int id) {
        return dsl.deleteFrom(e)
                .where(e.ID.eq(id))
                .execute();
    }
}


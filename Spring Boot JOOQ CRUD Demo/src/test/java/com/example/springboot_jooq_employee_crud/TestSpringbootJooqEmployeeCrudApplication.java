package com.example.springboot_jooq_employee_crud;

import org.springframework.boot.SpringApplication;

public class TestSpringbootJooqEmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringbootJooqEmployeeCrudApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

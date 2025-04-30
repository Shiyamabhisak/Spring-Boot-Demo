package com.example.springboot_jooq_employee_crud.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
class JooqConfig {
    @Bean
    public DSLContext dsl(DataSource ds) {
        return new DefaultDSLContext(new DefaultConfiguration().set(ds).set(SQLDialect.POSTGRES));
    }
}

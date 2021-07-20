package com.vladimir1506.crud_hibernate.utils;

import com.googlecode.flyway.core.Flyway;

public class FlywayIntegrator {
    public void migrate(){
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:postgresql://localhost:5432/crud_hibernate", "postgres", "root");
        flyway.migrate();
    }
}

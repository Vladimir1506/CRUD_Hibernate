package com.vladimir1506.crud_hibernate;

import com.vladimir1506.crud_hibernate.utils.FlywayIntegrator;
import com.vladimir1506.crud_hibernate.view.MainView;

public class Main {
    public static void main(String[] args) {
        new FlywayIntegrator().migrate();
        new MainView().start();
    }
}

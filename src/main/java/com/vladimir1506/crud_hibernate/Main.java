package com.vladimir1506.crud_hibernate;

import com.vladimir1506.crud_hibernate.model.Region;
import com.vladimir1506.crud_hibernate.view.MainView;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        new MainView().start();

    }
}

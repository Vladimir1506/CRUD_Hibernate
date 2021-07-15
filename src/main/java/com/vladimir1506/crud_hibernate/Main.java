package com.vladimir1506.crud_hibernate;

import com.vladimir1506.crud_hibernate.view.MainView;

public class Main {
    public static void main(String[] args) {
        new MainView().start();
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        Transaction transaction = session.beginTransaction();
//        List users = session.createQuery("from User").list();
//        transaction.commit();
//        System.out.println(users);

    }
}

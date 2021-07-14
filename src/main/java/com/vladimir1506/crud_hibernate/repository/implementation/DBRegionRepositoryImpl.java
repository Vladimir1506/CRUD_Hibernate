package com.vladimir1506.crud_hibernate.repository.implementation;

import com.vladimir1506.crud_hibernate.HibernateUtil;
import com.vladimir1506.crud_hibernate.model.Post;
import com.vladimir1506.crud_hibernate.model.Region;
import com.vladimir1506.crud_hibernate.repository.RegionRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBRegionRepositoryImpl implements RegionRepository {

    @Override
    public List<Region> getAll() {
        List<Region> regions = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            regions = session.createQuery("from Region").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return regions;
    }

    @Override
    public Region save(Region region) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(region);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
    }

    @Override
    public Region getById(Long id) {
        Transaction transaction = null;
        Region region = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            region = session.get(Region.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
    }

    @Override
    public Region update(Region region) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(region);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        Region region = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            region = session.get(Region.class, id);
            session.delete(region);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

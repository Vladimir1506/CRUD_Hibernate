package com.vladimir1506.crud_hibernate.repository.implementation;

import com.vladimir1506.crud_hibernate.utils.HibernateUtil;
import com.vladimir1506.crud_hibernate.model.Post;
import com.vladimir1506.crud_hibernate.repository.PostRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class DBPostRepositoryImpl implements PostRepository {

    @Override
    public List<Post> getAll() {
        List<Post> posts = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            posts = session.createQuery("from Post").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return posts;
    }

    @Override
    public Post getById(Long id) {
        Transaction transaction = null;
        Post post = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            post = session.get(Post.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return post;
    }

    @Override
    public Post save(Post post) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(post);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return post;
    }

    @Override
    public Post update(Post post) {
        Transaction transaction = null;
        Post oldPost;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            oldPost = getById(post.getId());
            System.out.println(oldPost);
            post.setCreated(oldPost.getCreated());
            post.setUpdated(new Date());
            post.setUser(oldPost.getUser());
            System.out.println(post);
            session.saveOrUpdate(post);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return post;
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        Post post;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            post = session.get(Post.class, id);
            session.delete(post);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

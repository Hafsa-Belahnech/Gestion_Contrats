package ma.entreprise.service;

import ma.entreprise.dao.IDao;
import ma.entreprise.entities.*;
import ma.entreprise.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public abstract class AbstractFacade<T> implements IDao<T> {
    private Class<T> entityClass;

   public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }



    @Override
    public boolean create(T o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return false;
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public T findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T entity = session.get(entityClass, id);
        session.close();
        return entity;
    }

    @Override
    public List<T> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // HQL : "from NomDeLaClasse"
        List<T> entities = session.createQuery("from " + entityClass.getSimpleName()).list();
        session.close();
        return entities;
    }
}

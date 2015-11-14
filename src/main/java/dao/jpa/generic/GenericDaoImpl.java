package dao.jpa.generic;

import dao.GenericDAO;
import data.Identifiable;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public abstract class GenericDaoImpl<T extends Identifiable> implements GenericDAO<T> {
    @Override
    public List<T> getAll() {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        final List<T> objects = session.createQuery("from " + getEntityName()).list();

        session.getTransaction().commit();
        session.close();

        return objects;
    }

    @Override
    public T findById(int id) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        final List<T> objects = session
                .createQuery("from " + getEntityName() + " obj where obj.id = :id")
                .setParameter("id", id).list();

        session.getTransaction().commit();
        session.close();

        return objects.size() > 0 ? objects.get(0) : null;
    }

    @Override
    public void insert(T obj) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void update(T obj) {
        // check if exists
        if (findById(obj.getId()) == null) {
            insert(obj);
            return;
        }

        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(obj);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update in table Player succeed!");
    }

    @Override
    public boolean deleteById(int id) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        final int deleted = session
                .createQuery("delete " + getEntityName() + " obj where obj.id = :id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();

        return deleted == 1;
    }

    @Override
    public boolean delete(T obj) {
        return deleteById(obj.getId());
    }

    private String getEntityName() {
        final String simpleName = getClass().getSimpleName();
        return simpleName.substring(0, simpleName.length() - 3);
    }
}

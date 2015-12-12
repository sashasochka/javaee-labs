package beans.ejb;

import data.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import javax.ejb.*;
import java.util.List;

@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CompanyBean {

    public List<Company> getCompanies() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createCriteria(Company.class).list();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void save(Company company) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if (company.getId() == 0) {
            session.persist("company", company);
        } else {
            session.update("company", company);
        }
        session.getTransaction().commit();
        session.close();
    }
}

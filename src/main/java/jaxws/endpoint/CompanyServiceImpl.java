package jaxws.endpoint;

import beans.ejb.CompanyBean;
import data.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

@WebService(endpointInterface = "jaxws.endpoint.CompanyService", serviceName = "companyServiceWS")
public class CompanyServiceImpl implements CompanyService {
    @Override
    public void createCompany(Company company) {
        try {
            ((CompanyBean) new InitialContext().lookup("java:module/CompanyBean")).save(company);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Company> getCompanies() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createCriteria(Company.class).list();
    }
}

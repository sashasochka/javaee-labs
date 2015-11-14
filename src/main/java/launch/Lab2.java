package launch;

import data.Company;
import data.Position;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class Lab2 {
    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        final List<Company> companies = session.createQuery("from Company").list();

        for (Company company : companies) {
            System.out.println("Company (" + company.getName() + ") : " +
                    company.getDescription());
        }

        final List<Position> positions = session.createQuery("from Position ").list();

        for (Position position : positions) {
            System.out.println("Position (" + position.getName() + ") : " +
                    position.getDescription() + ", Company: " +
                    position.getCompany().getName());
        }


        session.getTransaction().commit();
        session.close();
    }
}
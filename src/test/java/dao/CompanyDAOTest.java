package dao;

import data.Company;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DBManager;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CompanyDAOTest {
    Company microsoft = new Company();
    Company google = new Company();
    Company facebook = new Company();

    @Before
    public void setUp() throws Exception {
        microsoft.setName("Microsoft Corporation");
        microsoft.setDescription("One of the first and biggest software companies in the world");

        google.setName("Google Inc.");
        google.setDescription("Leading internet services and software company");

        facebook.setName("Facebook");
        facebook.setDescription("Biggest social network company");

        DBManager.getInstance().initializeDatabase();
    }

    @After
    public void tearDown() throws Exception {
        DBManager.getInstance().deleteDatabase();
    }

    @Test
    public void testGetAll() throws Exception {
        CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();
        companyDAO.insert(microsoft);
        companyDAO.insert(google);
        companyDAO.insert(facebook);

        List<Company> companies = companyDAO.getAll();
        assertEquals(companies.get(0), microsoft);
        assertEquals(companies.get(1), google);
        assertEquals(companies.get(2), facebook);
    }

    @Test
    public void testFindById() throws Exception {
        CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();
        companyDAO.insert(microsoft);
        companyDAO.insert(google);
        companyDAO.insert(facebook);

        assertEquals(companyDAO.findById(1), microsoft);
        assertEquals(companyDAO.findById(2), google);
        assertEquals(companyDAO.findById(3), facebook);
    }

    @Test
    public void testUpdate() throws Exception {
        CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();
        companyDAO.insert(microsoft);
        companyDAO.insert(google);
        companyDAO.insert(facebook);

        google.setName("Alphabet");

        companyDAO.update(google);

        assertEquals(companyDAO.findById(1), microsoft); // not changed
        assertEquals(companyDAO.findById(2), google);
        assertEquals(companyDAO.findById(2).getName(), "Alphabet");
    }

    @Test
    public void testDeleteById() throws Exception {
        CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();
        companyDAO.insert(microsoft);
        companyDAO.insert(google);
        companyDAO.insert(facebook);

        companyDAO.deleteById(2);

        assertNull(companyDAO.findById(2));
    }

    @Test
    public void testDelete() throws Exception {
        CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();
        companyDAO.insert(microsoft);
        companyDAO.insert(google);
        companyDAO.insert(facebook);

        companyDAO.delete(google);

        assertNull(companyDAO.findById(2));
    }
}
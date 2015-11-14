package dao.jdbc;

import dao.DAOFactory;
import dao.GenericDAO;
import dao.IDAOFactory;
import data.Company;
import data.Position;
import data.Worker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DBManager;

import static org.junit.Assert.assertEquals;

public class WorkerDAOTest {
    IDAOFactory daoFactory;
    Company microsoft = new Company();
    Company google = new Company();
    Company facebook = new Company();

    Position microsoftCEO = new Position();
    Position microsoftCVP = new Position();
    Position googleCVP = new Position();

    Worker satyaNadella = new Worker();
    Worker terryMyerson = new Worker();

    @Before
    public void setUp() throws Exception {
        microsoft.setName("Microsoft Corporation");
        microsoft.setDescription("One of the first and biggest software companies in the world");

        google.setName("Google Inc.");
        google.setDescription("Leading internet services and software company");

        facebook.setName("Facebook");
        facebook.setDescription("Biggest social network company");

        microsoftCEO.setName("Microsoft CEO");
        microsoftCEO.setCompany(microsoft);
        microsoftCEO.setDescription("Responsible for managing the whole company");

        microsoftCVP.setName("Microsoft CVP");
        microsoftCVP.setCompany(microsoft);
        microsoftCVP.setDescription("Responsible for managing subdivision of the company");

        googleCVP.setName("Google CVP");
        googleCVP.setCompany(google);
        googleCVP.setDescription("Responsible for managing subdivision of GOOGLE");

        satyaNadella.setName("Satya Nadella");
        satyaNadella.setPosition(microsoftCEO);
        satyaNadella.setSalary(10000000);

        terryMyerson.setName("Terry Myerson");
        terryMyerson.setPosition(microsoftCVP);
        terryMyerson.setSalary(5000000);

        DBManager.getInstance().initializeDatabase();

        daoFactory = DAOFactory.getJDBCInstance();
    }

    @After
    public void tearDown() throws Exception {
        DBManager.getInstance().deleteDatabase();
    }

    @Test
    public void testGetAll() throws Exception {
        GenericDAO<Company> companyDAO = daoFactory.getCompanyDAO();
        companyDAO.insert(microsoft);

        GenericDAO<Position> positionDAO = daoFactory.getPositionDAO();
        positionDAO.insert(microsoftCEO);
        positionDAO.insert(microsoftCVP);

        GenericDAO<Worker> workerDAO = daoFactory.getWorkerDAO();
        workerDAO.insert(satyaNadella);
        workerDAO.insert(terryMyerson);

        assertEquals(workerDAO.getAll().size(), 2);
    }

    @Test
    public void testFindById() throws Exception {

        GenericDAO<Company> companyDAO = daoFactory.getCompanyDAO();
        companyDAO.insert(microsoft);

        GenericDAO<Position> positionDAO = daoFactory.getPositionDAO();
        positionDAO.insert(microsoftCEO);
        positionDAO.insert(microsoftCVP);

        GenericDAO<Worker> workerDAO = daoFactory.getWorkerDAO();
        workerDAO.insert(satyaNadella);
        workerDAO.insert(terryMyerson);

        assertEquals(workerDAO.findById(2), terryMyerson);
    }

    @Test
    public void testUpdate() throws Exception {
        GenericDAO<Company> companyDAO = daoFactory.getCompanyDAO();
        companyDAO.insert(microsoft);
        companyDAO.insert(google);

        GenericDAO<Position> positionDAO = daoFactory.getPositionDAO();
        positionDAO.insert(microsoftCEO);
        positionDAO.insert(microsoftCVP);
        positionDAO.insert(googleCVP);

        GenericDAO<Worker> workerDAO = daoFactory.getWorkerDAO();
        workerDAO.insert(satyaNadella);
        workerDAO.insert(terryMyerson);

        terryMyerson.setPosition(googleCVP);
        workerDAO.update(terryMyerson);

        assertEquals(workerDAO.findById(2).getPosition(), googleCVP);
    }
}
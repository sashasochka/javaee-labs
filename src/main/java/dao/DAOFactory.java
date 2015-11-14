package dao;

import data.*;

public class DAOFactory {
    static private IDAOFactory jdbcInstance;
    static private IDAOFactory jpaInstance;

    synchronized static public IDAOFactory getJDBCInstance() {
        if (jdbcInstance == null) {
            jdbcInstance = new JDBCDAOFactory();
        }
        return jdbcInstance;
    }

    synchronized static public IDAOFactory getJPAInstance() {
        if (jpaInstance == null) {
            jpaInstance = new JPADAOFactory();
        }
        return jpaInstance;
    }
}

class JDBCDAOFactory implements IDAOFactory {
    private GenericDAO<Company> companyDAO = new dao.jdbc.CompanyDAO();
    private GenericDAO<Position> positionDAO = new dao.jdbc.PositionDAO();
    private GenericDAO<Candidate> candidateDAO = new dao.jdbc.CandidateDAO();
    private GenericDAO<Vacancy> vacancyDAO = new dao.jdbc.VacancyDAO();
    private GenericDAO<Worker> workerDAO = new dao.jdbc.WorkerDAO();

    public GenericDAO<Company> getCompanyDAO() {
        return companyDAO;
    }

    public GenericDAO<Position> getPositionDAO() {
        return positionDAO;
    }

    public GenericDAO<Candidate> getCandidateDAO() {
        return candidateDAO;
    }

    public GenericDAO<Vacancy> getVacancyDAO() {
        return vacancyDAO;
    }

    public GenericDAO<Worker> getWorkerDAO() {
        return workerDAO;
    }
}

class JPADAOFactory implements IDAOFactory {
    private GenericDAO<Company> companyDAO = new dao.jpa.CompanyDAO();
    private GenericDAO<Position> positionDAO = new dao.jpa.PositionDAO();
    private GenericDAO<Candidate> candidateDAO = new dao.jpa.CandidateDAO();
    private GenericDAO<Vacancy> vacancyDAO = new dao.jpa.VacancyDAO();
    private GenericDAO<Worker> workerDAO = new dao.jpa.WorkerDAO();

    public GenericDAO<Company> getCompanyDAO() {
        return companyDAO;
    }

    public GenericDAO<Position> getPositionDAO() {
        return positionDAO;
    }

    public GenericDAO<Candidate> getCandidateDAO() {
        return candidateDAO;
    }

    public GenericDAO<Vacancy> getVacancyDAO() {
        return vacancyDAO;
    }

    public GenericDAO<Worker> getWorkerDAO() {
        return workerDAO;
    }
}

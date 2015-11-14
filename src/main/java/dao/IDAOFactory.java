package dao;

import data.*;

public interface IDAOFactory {
    GenericDAO<Company> getCompanyDAO();

    GenericDAO<Position> getPositionDAO();

    GenericDAO<Candidate> getCandidateDAO();

    GenericDAO<Vacancy> getVacancyDAO();

    GenericDAO<Worker> getWorkerDAO();
}

package dao;

public class DAOFactory {
    static private DAOFactory instance;
    private CompanyDAO companyDAO = new CompanyDAO();
    private PositionDAO positionDAO = new PositionDAO();
    private CandidateDAO candidateDAO = new CandidateDAO();
    private VacancyDAO vacancyDAO = new VacancyDAO();
    private WorkerDAO workerDAO = new WorkerDAO();

    synchronized static public DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public CompanyDAO getCompanyDAO() {
        return companyDAO;
    }

    public PositionDAO getPositionDAO() {
        return positionDAO;
    }

    public CandidateDAO getCandidateDAO() {
        return candidateDAO;
    }

    public VacancyDAO getVacancyDAO() {
        return vacancyDAO;
    }

    public WorkerDAO getWorkerDAO() {
        return workerDAO;
    }
}

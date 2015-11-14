package beans;

import dao.DAOFactory;
import data.Company;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CompanyAdderBean {
    private Company company = new Company();

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void add() {
        DAOFactory.getJPAInstance().getCompanyDAO().insert(company);
    }
}

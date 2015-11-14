package beans;

import dao.DAOFactory;
import data.Company;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class CompanyListBean {
    List<Company> companies;

    public List<Company> getCompanies() {
        return DAOFactory.getJPAInstance().getCompanyDAO().getAll();
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}

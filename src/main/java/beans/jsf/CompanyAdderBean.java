package beans.jsf;

import beans.ejb.CompanyBean;
import data.Company;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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

    public void add() throws NamingException {
        ((CompanyBean) new InitialContext().lookup("java:module/CompanyBean")).save(company);
    }
}

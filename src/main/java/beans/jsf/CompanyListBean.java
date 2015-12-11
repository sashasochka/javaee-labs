package beans.jsf;

import beans.ejb.CompanyBean;
import data.Company;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

@ManagedBean
@RequestScoped
public class CompanyListBean {
    List<Company> companies;

    public List<Company> getCompanies() throws NamingException {
        return ((CompanyBean) new InitialContext().lookup("java:module/CompanyBean")).getCompanies();
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}

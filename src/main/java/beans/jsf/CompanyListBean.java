package beans.jsf;

import beans.ejb.CompanyJBean;
import data.Company;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.util.List;

@ManagedBean
@RequestScoped
public class CompanyListBean {
    List<Company> companies;

    public List<Company> getCompanies() throws NamingException, MalformedURLException {
        return ((CompanyJBean) new InitialContext().lookup("java:module/CompanyJBean")).getCompanies();
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}

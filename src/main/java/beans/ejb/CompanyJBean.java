package beans.ejb;


import data.Company;

import javax.ejb.Local;
import java.net.MalformedURLException;
import java.util.List;

@Local
public interface CompanyJBean {
    List<Company> getCompanies() throws MalformedURLException;

}

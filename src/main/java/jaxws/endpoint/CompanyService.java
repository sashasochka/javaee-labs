package jaxws.endpoint;

import data.Company;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface CompanyService {
    void createCompany(Company company);

    List<Company> getCompanies();
}

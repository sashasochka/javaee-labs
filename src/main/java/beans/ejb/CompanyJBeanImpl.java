package beans.ejb;

import data.Company;
import jaxws.client.CompanyService;
import jaxws.client.CompanyServiceWS;

import javax.ejb.Stateless;
import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Stateless(name = "CompanyJBean")
public class CompanyJBeanImpl implements CompanyJBean {

    @Override
    public List<Company> getCompanies() throws MalformedURLException {
        URL url = new URL("http://localhost:8081/jax-ws?wsdl");
        QName qName = new QName("http://endpoint.jaxws/", "companyServiceWS");
        CompanyServiceWS companyServiceWS = new CompanyServiceWS(url, qName);
        CompanyService companyService = companyServiceWS.getCompanyServiceImplPort();
        List<Company> companies = new LinkedList<>();
        for (jaxws.client.Company company : companyService.getCompanies()) {
            Company comp = new Company();
            comp.setDescription(comp.getDescription());
            comp.setId(comp.getId());
            comp.setName(comp.getName());
            companies.add(comp);
        }
        return companies;
    }
}

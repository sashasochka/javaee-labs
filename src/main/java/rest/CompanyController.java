package rest;

import beans.ejb.CompanyBean;
import data.Company;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@ApplicationPath("/api")
@Path("/company")
public class CompanyController {
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAllCompanies() {
        try {
            List<Company> companies = ((CompanyBean) new InitialContext().lookup("java:module/CompanyBean")).getCompanies();
            for (Company company : companies) {
                company.setPositions(Arrays.asList());
            }
            return companies;
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

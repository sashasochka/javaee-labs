package servlets;

import dao.CompanyDAO;
import dao.DAOFactory;
import data.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/companies"})
public class CompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();
        final PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.write("List of companies" +
            "<table border=1>" +
            "<tr>" +
            "<th>ID</th>" +
            "<th>Name</th>" +
            "<th>Description</th>" +
            "</tr>");

        for (Company company : companyDAO.getAll()) {
            writer.write("<tr><td>" + company.getId() + "</td>" +
                "<td>" + company.getName() + "</td>" +
                "<td>" + company.getDescription() + "</td></tr>");
        }
        writer.write("</table>");
        writer.write("<hr>");
        writer.write("<form method=post>" +
                "<table>" +
                "<tr><td>Name</td><td><input name=name></tr>" +
                "<tr><td>Description</td><td><input name=description></tr>" +
                "<tr><td colspan=2><input type=submit></td></tr>" +
                "</table>" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();

        final Company company = new Company();
        company.setName(req.getParameter("name"));
        company.setDescription(req.getParameter("description"));
        companyDAO.insert(company);

        resp.sendRedirect("companies");
    }
}

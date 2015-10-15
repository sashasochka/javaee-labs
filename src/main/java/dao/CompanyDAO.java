package dao;

import dao.generic.GenericDaoImpl;
import data.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO extends GenericDaoImpl<Company> {
    @Override
    protected String getTableName() {
        return "company";
    }

    @Override
    protected ResultSet insertImpl(Connection connection, Company company) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO " + getTableName() + " " +
                        "(NAME, DESCRIPTION) VALUES (?, ?)");

        statement.setString(1, company.getName());
        statement.setString(2, company.getDescription());
        statement.executeUpdate();
        return statement.getGeneratedKeys();
    }

    @Override
    protected int updateImpl(Connection connection, Company company) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE " + getTableName() + " SET " +
                        "NAME = ?, " +
                        "DESCRIPTION = ? " +
                        "WHERE ID = ?");
        statement.setString(1, company.getName());
        statement.setString(2, company.getDescription());
        statement.setInt(3, company.getId());
        return statement.executeUpdate();
    }

    @Override
    public List<Company> mapAll(ResultSet set) {
        List<Company> result = new ArrayList<>();
        try {
            while (set.next()) {
                Company company = new Company();
                company.setId(set.getInt("id"));
                company.setName(set.getString("name"));
                company.setDescription(set.getString("description"));
                result.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

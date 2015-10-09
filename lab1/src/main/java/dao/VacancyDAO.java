package dao;

import dao.generic.GenericDaoImpl;
import data.Vacancy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacancyDAO extends GenericDaoImpl<Vacancy> {
    @Override
    protected String getTableName() {
        return "vacancy";
    }

    @Override
    protected ResultSet insertImpl(Connection connection, Vacancy vacancy) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO " + getTableName() + " " +
                        "(DESCRIPTION, POSITION_ID, SALARY) VALUES (?, ?, ?)");

        statement.setString(1, vacancy.getDescription());
        statement.setInt(2, vacancy.getPosition().getId());
        statement.setInt(3, vacancy.getSalary());
        statement.executeUpdate();
        return statement.getGeneratedKeys();
    }

    @Override
    protected int updateImpl(Connection connection, Vacancy vacancy) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE " + getTableName() + " SET " +
                        "DESCRIPTION = ?, " +
                        "POSITION_ID = ?, " +
                        "SALARY = ? " +
                        "WHERE ID = ?");
        statement.setString(1, vacancy.getDescription());
        statement.setInt(2, vacancy.getPosition().getId());
        statement.setInt(3, vacancy.getSalary());
        statement.setInt(4, vacancy.getId());
        return statement.executeUpdate();
    }

    @Override
    public List<Vacancy> mapAll(ResultSet set) {
        List<Vacancy> result = new ArrayList<>();
        try {
            while (set.next()) {
                Vacancy vacancy = new Vacancy();
                vacancy.setId(set.getInt("id"));
                vacancy.setDescription(set.getString("description"));
                vacancy.setSalary(set.getInt("salary"));
                vacancy.setPosition(DAOFactory.getInstance().getPositionDAO().findById(
                        set.getInt("position_id")));
                result.add(vacancy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

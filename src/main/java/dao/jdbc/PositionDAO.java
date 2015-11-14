package dao.jdbc;

import dao.DAOFactory;
import dao.jdbc.generic.GenericDaoImpl;
import data.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO extends GenericDaoImpl<Position> {
    @Override
    protected String getTableName() {
        return "position";
    }

    @Override
    protected ResultSet insertImpl(Connection connection, Position position) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO " + getTableName() + " " +
                        "(NAME, DESCRIPTION, COMPANY_ID) VALUES (?, ?, ?)");

        statement.setString(1, position.getName());
        statement.setString(2, position.getDescription());
        statement.setInt(3, position.getCompany().getId());
        statement.executeUpdate();
        return statement.getGeneratedKeys();
    }

    @Override
    protected int updateImpl(Connection connection, Position position) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE " + getTableName() + " SET " +
                        "NAME = ?, " +
                        "DESCRIPTION = ?, " +
                        "COMPANY_ID = ? " +
                        "WHERE ID = ?");
        statement.setString(1, position.getName());
        statement.setString(2, position.getDescription());
        statement.setInt(3, position.getCompany().getId());
        statement.setInt(4, position.getId());
        return statement.executeUpdate();
    }

    @Override
    public List<Position> mapAll(ResultSet set) {
        List<Position> result = new ArrayList<>();
        try {
            while (set.next()) {
                Position position = new Position();
                position.setId(set.getInt("id"));
                position.setName(set.getString("name"));
                position.setDescription(set.getString("description"));
                position.setCompany(DAOFactory.getJDBCInstance().getCompanyDAO().findById(
                        set.getInt("company_id")));
                result.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

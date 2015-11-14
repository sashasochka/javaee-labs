package dao.jdbc;

import dao.DAOFactory;
import dao.jdbc.generic.GenericDaoImpl;
import data.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO extends GenericDaoImpl<Worker> {
    @Override
    protected String getTableName() {
        return "worker";
    }

    @Override
    protected ResultSet insertImpl(Connection connection, Worker worker) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO " + getTableName() + " " +
                        "(NAME, POSITION_ID, SALARY) VALUES (?, ?, ?)");

        statement.setString(1, worker.getName());
        statement.setInt(2, worker.getPosition().getId());
        statement.setInt(3, worker.getSalary());
        statement.executeUpdate();
        return statement.getGeneratedKeys();
    }

    @Override
    protected int updateImpl(Connection connection, Worker worker) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE " + getTableName() + " SET " +
                        "NAME = ?, " +
                        "POSITION_ID = ?, " +
                        "SALARY = ? " +
                        "WHERE ID = ?");
        statement.setString(1, worker.getName());
        statement.setInt(2, worker.getPosition().getId());
        statement.setInt(3, worker.getSalary());
        statement.setInt(4, worker.getId());
        return statement.executeUpdate();
    }

    @Override
    public List<Worker> mapAll(ResultSet set) {
        List<Worker> result = new ArrayList<>();
        try {
            while (set.next()) {
                Worker worker = new Worker();
                worker.setId(set.getInt("id"));
                worker.setName(set.getString("name"));
                worker.setSalary(set.getInt("salary"));
                worker.setPosition(DAOFactory.getJDBCInstance().getPositionDAO().findById(
                        set.getInt("position_id")));
                result.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}

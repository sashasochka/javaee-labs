package dao.jdbc.generic;

import dao.GenericDAO;
import data.Identifiable;
import util.DBManager;

import java.sql.*;
import java.util.List;

public abstract class GenericDaoImpl<T extends Identifiable> implements GenericDAO<T> {
    private static Connection connection = DBManager.getInstance().getConnection();

    abstract protected String getTableName();

    abstract public List<T> mapAll(ResultSet set);

    abstract protected ResultSet insertImpl(Connection connection, T obj) throws SQLException;

    abstract protected int updateImpl(Connection connection, T obj) throws SQLException;

    @Override
    public List<T> getAll() {
        try (Statement stmt = connection.createStatement()) {
            final String sql = "SELECT * FROM " + getTableName();
            return mapAll(stmt.executeQuery(sql));
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T findById(int id) {
        ResultSet resultSet;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM " + getTableName() + " WHERE id=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            return map(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(T obj) {
        try {
            try (ResultSet generatedKeys = insertImpl(connection, obj)) {
                if (generatedKeys.next()) {
                    obj.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(T obj) {
        // check if exists
        if (findById(obj.getId()) == null) {
            insert(obj);
            return;
        }

        try {
            assert updateImpl(connection, obj) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Update in table Player succeed!");
    }

    @Override
    public boolean deleteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM " + getTableName() + " WHERE id=?");
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(T obj) {
        return deleteById(obj.getId());
    }

    public T map(ResultSet set) {
        List<T> mapped = mapAll(set);
        if (mapped.isEmpty()) {
            return null;
        }
        assert mapped.size() == 1;
        return mapped.get(0);
    }
}

package dao.jdbc;

import dao.DAOFactory;
import dao.jdbc.generic.GenericDaoImpl;
import data.Candidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO extends GenericDaoImpl<Candidate> {

    @Override
    protected String getTableName() {
        return "candidate";
    }

    @Override
    protected ResultSet insertImpl(Connection connection, Candidate obj) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO " + getTableName() + " " +
                        "(NAME, RESUME) VALUES (?, ?)");

        statement.setString(1, obj.getName());
        statement.setString(2, obj.getResume());
        statement.executeUpdate();
        return statement.getGeneratedKeys();
    }

    @Override
    protected int updateImpl(Connection connection, Candidate candidate) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE " + getTableName() + " SET " +
                        "NAME = ?, " +
                        "RESUME = ?, " +
                        "VACANCY_ID = ? " +
                        "WHERE ID = ?");
        statement.setString(1, candidate.getName());
        statement.setString(2, candidate.getResume());
        statement.setInt(3, candidate.getVacancy().getId());
        statement.setInt(4, candidate.getId());
        return statement.executeUpdate();
    }

    @Override
    public List<Candidate> mapAll(ResultSet set) {
        List<Candidate> result = new ArrayList<>();
        try {
            while (set.next()) {
                Candidate candidate = new Candidate();
                candidate.setId(set.getInt("id"));
                candidate.setName(set.getString("name"));
                candidate.setResume(set.getString("resume"));
                candidate.setVacancy(DAOFactory.getJDBCInstance().getVacancyDAO().findById(
                        set.getInt("vacancy_id")));
                result.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

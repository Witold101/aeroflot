package by.school.aeroflot.dao.implDao;

import by.school.aeroflot.dao.DAO;
import by.school.aeroflot.dao.DAOSuport;
import by.school.aeroflot.entities.Airport;
import by.school.aeroflot.entities.Team;
import by.school.aeroflot.exceptions.InfoException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static by.school.aeroflot.db.SQLQueryConstants.TEAM_TABLE;

public class DAOTeam implements DAO<Team, Long>, DAOSuport {
    private static volatile DAOTeam INSTANCE = null;
    private Map<String, PreparedStatement> pstMap;

    private static final String saveItemQuery = "INSERT INTO " + TEAM_TABLE
            + " (ID,PILOT, RADIOOPERATOR, NAVIGATOR, STEWARDESS) VALUES (?, ?, ?, ?, ?)";
    private static final String updateItemQuery = "UPDATE " + TEAM_TABLE
            + " SET PILOT=?, RADIOOPERATOR=?, NAVIGATOR=?, STEWARDESS=? WHERE ID=?";
    private static final String getItemQuery = "SELECT * FROM " + TEAM_TABLE
            + " WHERE ID=?";
    private static final String deleteItemQuery = "DELETE FROM " + TEAM_TABLE
            + " WHERE ID=?";

    private DAOTeam() {
    }

    public static DAOTeam getInstance() {
        DAOTeam dao = INSTANCE;
        if (dao == null) {
            synchronized (DAOTeam.class) {
                dao = INSTANCE;
                if (dao == null) {
                    INSTANCE = dao = new DAOTeam();
                }
            }
        }
        return dao;
    }

    @Override
    public Team save(Team team) throws SQLException {
        PreparedStatement pst = pstMap.get("save");
        if (team.getId() != null) {
            pst.setLong(1, team.getId());
            pst.setInt(2, team.getPilot());
            pst.setInt(3, team.getRadiooperator());
            pst.setInt(4, team.getNavigator());
            pst.setInt(5, team.getStewardess());
            pst.executeUpdate();
        } else {
            throw new InfoException("Error." +
                    " There is no ID Team. It is required to define ID for communication of tables ");
        }
        return team;
    }

    @Override
    public Team get(Long id) throws SQLException {
        Team team = new Team();
        PreparedStatement pst = pstMap.get("get");
        pst.setLong(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        rs.next();
        team.setId(rs.getLong("ID"));
        team.setPilot(rs.getInt("PILOT"));
        team.setRadiooperator(rs.getInt("RADIOOPERATOR"));
        team.setNavigator(rs.getInt("NAVIGATOR"));
        team.setStewardess(rs.getInt("STEWARDESS"));
        rs.close();
        return team;
    }

    @Override
    public void update(Team team) throws SQLException {
        PreparedStatement pst = pstMap.get("update");
        pst.setInt(1, team.getPilot());
        pst.setInt(2, team.getRadiooperator());
        pst.setInt(3, team.getNavigator());
        pst.setInt(4, team.getStewardess());
        pst.setLong(5, team.getId());
        pst.executeUpdate();
    }

    @Override
    public void delete(Long id) throws SQLException {
        PreparedStatement pst = pstMap.get("delete");
        pst.setLong(1, id);
        pst.executeUpdate();
    }

    @Override
    public void initPreparedStatement(Connection connection) throws SQLException {
        this.pstMap = new HashMap<>();
        pstMap.put("save", connection.prepareStatement(saveItemQuery, Statement.RETURN_GENERATED_KEYS));
        pstMap.put("update", connection.prepareStatement(updateItemQuery));
        pstMap.put("get", connection.prepareStatement(getItemQuery));
        pstMap.put("delete", connection.prepareStatement(deleteItemQuery));
    }

    @Override
    public void closePreparedStatement() throws SQLException {
        for (PreparedStatement pst : this.pstMap.values()) {
            if (pst != null) {
                pst.close();
            }
        }
    }
}

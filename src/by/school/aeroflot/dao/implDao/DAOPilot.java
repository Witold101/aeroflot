package by.school.aeroflot.dao.implDao;

import by.school.aeroflot.dao.DAO;
import by.school.aeroflot.dao.DAOSuport;
import by.school.aeroflot.entities.Navigator;
import by.school.aeroflot.entities.Pilot;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static by.school.aeroflot.db.SQLQueryConstants.*;

public class DAOPilot implements DAO<Pilot,Long>,DAOSuport {

    private static volatile DAOPilot INSTANCE = null;
    private Map<String, PreparedStatement> pstMap;

    private static final String saveItemQuery = "INSERT INTO " + PILOT_TABLE
            + " (NAME, LAST_NAME, FLY_LIST_ID) VALUES (?, ?, ?)";
    private static final String updateItemQuery = "UPDATE " + PILOT_TABLE
            + " SET NAME=?, LAST_NAME=?, FLY_LIST_ID=? WHERE ID=?";
    private static final String getItemQuery = "SELECT * FROM " + PILOT_TABLE
            + " WHERE ID=?";
    private static final String deleteItemQuery = "DELETE FROM " + PILOT_TABLE
            + " WHERE ID=?";

    private DAOPilot() {
    }

    public static DAOPilot getInstance() {
        DAOPilot dao = INSTANCE;
        if (dao == null) {
            synchronized (DAOPilot.class) {
                dao = INSTANCE;
                if (dao == null) {
                    INSTANCE = dao = new DAOPilot();
                }
            }
        }
        return dao;
    }

    @Override
    public Pilot save(Pilot pilot) throws SQLException {
        PreparedStatement pst = pstMap.get("save");
        pst.setString(1, pilot.getName());
        pst.setString(2, pilot.getLastName());
        pst.setLong(3,pilot.getFlyListId());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            pilot.setId(rs.getLong(1));
        }
        rs.close();
        return pilot;
    }

    @Override
    public Pilot get(Long id) throws SQLException {
        Pilot pilot = new Pilot();
        PreparedStatement pst = pstMap.get("get");
        pst.setLong(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        rs.next();
        pilot.setId(rs.getLong("ID"));
        pilot.setName(rs.getString("NAME"));
        pilot.setLastName(rs.getString("LAST_NAME"));
        pilot.setFlyListId(rs.getLong("FLY_LIST_ID"));
        rs.close();
        return pilot;
    }

    @Override
    public void update(Pilot pilot) throws SQLException {
        PreparedStatement pst = pstMap.get("update");
        pst.setString(1, pilot.getName());
        pst.setString(2, pilot.getLastName());
        pst.setLong(3, pilot.getFlyListId());
        pst.setLong(4, pilot.getId());
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

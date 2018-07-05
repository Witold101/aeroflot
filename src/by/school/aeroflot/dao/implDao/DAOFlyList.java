package by.school.aeroflot.dao.implDao;

import by.school.aeroflot.dao.DAO;
import by.school.aeroflot.dao.DAOSuport;
import by.school.aeroflot.entities.Airport;
import by.school.aeroflot.entities.FlyList;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static by.school.aeroflot.db.SQLQueryConstants.*;

public class DAOFlyList implements DAO<FlyList, Long>, DAOSuport {
    private static volatile DAOFlyList INSTANCE = null;
    private Map<String, PreparedStatement> pstMap;

    private static final String saveItemQuery = "INSERT INTO " + FLY_LiST_TABLE
            + " (DATE, AIRPORT_START_ID, AIRPORT_FINISH_ID, ADMINISTRATOR_ID ) VALUES (?, ?, ?, ?)";
    private static final String updateItemQuery = "UPDATE " + FLY_LiST_TABLE
            + " SET DATE=?, AIRPORT_START_ID=?, AIRPORT_FINISH_ID=?, ADMINISTRATOR_ID=?  WHERE ID=?";
    private static final String getItemQuery = "SELECT * FROM " + FLY_LiST_TABLE
            + " WHERE ID=?";
    private static final String deleteItemQuery = "DELETE FROM " + FLY_LiST_TABLE
            + " WHERE ID=?";

    private DAOFlyList() {
    }

    public static DAOFlyList getInstance() {
        DAOFlyList dao = INSTANCE;
        if (dao == null) {
            synchronized (DAOFlyList.class) {
                dao = INSTANCE;
                if (dao == null) {
                    INSTANCE = dao = new DAOFlyList();
                }
            }
        }
        return dao;
    }

    @Override
    public FlyList save(FlyList flyList) throws SQLException {
        PreparedStatement pst = pstMap.get("save");
        pst.setDate(1, flyList.getDate());
        pst.setLong(2, flyList.getAirportStartId());
        pst.setLong(3, flyList.getAirportFinishId());
        pst.setLong(4, flyList.getAdministratorId());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            flyList.setId(rs.getLong(1));
        }
        rs.close();
        return flyList;
    }

    @Override
    public FlyList get(Long id) throws SQLException {
        FlyList flyList = new FlyList();
        PreparedStatement pst = pstMap.get("get");
        pst.setLong(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        rs.next();
        flyList.setId(rs.getLong("ID"));
        flyList.setDate(rs.getDate("DATE"));
        flyList.setAirportStartId(rs.getLong("AIRPORT_START_ID"));
        flyList.setAirportStartId(rs.getLong("AIRPORT_FINISH_ID"));
        flyList.setAirportStartId(rs.getLong("ADMINISTRATOR_ID"));
        rs.close();
        return flyList;
    }

    @Override
    public void update(FlyList flyList) throws SQLException {
        PreparedStatement pst = pstMap.get("update");
        pst.setDate(1, flyList.getDate());
        pst.setLong(2, flyList.getAirportStartId());
        pst.setLong(3, flyList.getAirportFinishId());
        pst.setLong(4, flyList.getAirportFinishId());
        pst.setLong(5, flyList.getId());
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

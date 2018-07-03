package by.school.aeroflot.dao.implDao;

import by.school.aeroflot.dao.DAO;
import by.school.aeroflot.dao.DAOSuport;
import by.school.aeroflot.entities.Administrator;
import by.school.aeroflot.entities.Navigator;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static by.school.aeroflot.db.SQLQueryConstants.NAVIGATOR_TABLE;

public class DAONavigator implements DAO<Navigator,Long>, DAOSuport {
    private static volatile DAONavigator INSTANCE = null;
    private Map<String, PreparedStatement> pstMap;

    private static final String saveItemQuery = "INSERT INTO " + NAVIGATOR_TABLE
            + " (NAME, LAST_NAME, FLY_LIST_ID) VALUES (?, ?, ?)";
    private static final String updateItemQuery = "UPDATE " + NAVIGATOR_TABLE
            + " SET NAME=?, LAST_NAME=?, FLY_LIST_ID=? WHERE ID=?";
    private static final String getItemQuery = "SELECT * FROM " + NAVIGATOR_TABLE
            + " WHERE ID=?";
    private static final String deleteItemQuery = "DELETE FROM " + NAVIGATOR_TABLE
            + " WHERE ID=?";

    private DAONavigator() {
    }

    public static DAONavigator getInstance() {
        DAONavigator dao = INSTANCE;
        if (dao == null) {
            synchronized (DAONavigator.class) {
                dao = INSTANCE;
                if (dao == null) {
                    INSTANCE = dao = new DAONavigator();
                }
            }
        }
        return dao;
    }

    @Override
    public Navigator save(Navigator navigator) throws SQLException {
        PreparedStatement pst = pstMap.get("save");
        pst.setString(1, navigator.getName());
        pst.setString(2, navigator.getLastName());
        pst.setLong(3,navigator.getFlyListId());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            navigator.setId(rs.getLong(1));
        }
        rs.close();
        return navigator;
    }

    @Override
    public Navigator get(Long id) throws SQLException {
        Navigator navigator = new Navigator();
        PreparedStatement pst = pstMap.get("get");
        pst.setLong(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        rs.next();
        navigator.setId(rs.getLong("ID"));
        navigator.setName(rs.getString("NAME"));
        navigator.setLastName(rs.getString("LAST_NAME"));
        navigator.setFlyListId(rs.getLong("FLY_LIST_ID"));
        rs.close();
        return navigator;
    }

    @Override
    public void update(Navigator navigator) throws SQLException {
        PreparedStatement pst = pstMap.get("update");
        pst.setString(1, navigator.getName());
        pst.setString(2, navigator.getLastName());
        pst.setLong(3, navigator.getFlyListId());
        pst.setLong(4, navigator.getId());
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

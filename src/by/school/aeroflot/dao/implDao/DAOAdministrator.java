package by.school.aeroflot.dao.implDao;

import by.school.aeroflot.dao.DAO;
import by.school.aeroflot.dao.DAOSuport;
import by.school.aeroflot.entities.Administrator;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static by.school.aeroflot.db.SQLQueryConstants.*;

public class DAOAdministrator implements DAO<Administrator, Long>, DAOSuport {
    private static volatile DAOAdministrator INSTANCE = null;
    private Map<String, PreparedStatement> pstMap;

    private static final String saveItemQuery = "INSERT INTO " + ADMINISTRATOR_TABLE
            + " (NAME, LAST_NAME) VALUES (?, ?)";
    private static final String updateItemQuery = "UPDATE " + ADMINISTRATOR_TABLE
            + " SET NAME=?, LAST_NAME=? WHERE ID=?";
    private static final String getItemQuery = "SELECT * FROM " + ADMINISTRATOR_TABLE
            + " WHERE ID=?";
    private static final String deleteItemQuery = "DELETE FROM " + ADMINISTRATOR_TABLE
            + " WHERE ID=?";

    private DAOAdministrator() {
    }

    public static DAOAdministrator getInstance() {
        DAOAdministrator dao = INSTANCE;
        if (dao == null) {
            synchronized (DAOAdministrator.class) {
                dao = INSTANCE;
                if (dao == null) {
                    INSTANCE = dao = new DAOAdministrator();
                }
            }
        }
        return dao;
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

    @Override
    public Administrator save(Administrator administrator) throws SQLException {
        PreparedStatement pst = pstMap.get("save");
        pst.setString(1, administrator.getName());
        pst.setString(2, administrator.getLastName());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            administrator.setId(rs.getLong(1));
        }
        rs.close();
        return administrator;
    }

    @Override
    public Administrator get(Long id) throws SQLException {
        Administrator administrator = new Administrator();
        PreparedStatement pst = pstMap.get("get");
        pst.setLong(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        rs.next();
        administrator.setId(rs.getLong("ID"));
        administrator.setName(rs.getString("NAME"));
        administrator.setLastName(rs.getString("LAST_NAME"));
        rs.close();
        return administrator;
    }

    @Override
    public void update(Administrator administrator) throws SQLException {
        PreparedStatement pst = pstMap.get("update");
        pst.setString(1, administrator.getName());
        pst.setString(2, administrator.getLastName());
        pst.setLong(3, administrator.getId());
        pst.executeUpdate();
    }

    @Override
    public void delete(Long id) throws SQLException {
        PreparedStatement pst = pstMap.get("delete");
        pst.setLong(1, id);
        pst.executeUpdate();
    }
}

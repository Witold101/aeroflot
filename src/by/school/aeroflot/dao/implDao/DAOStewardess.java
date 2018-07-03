package by.school.aeroflot.dao.implDao;

import by.school.aeroflot.dao.DAO;
import by.school.aeroflot.dao.DAOSuport;
import by.school.aeroflot.entities.Navigator;
import by.school.aeroflot.entities.Stewardess;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static by.school.aeroflot.db.SQLQueryConstants.*;

public class DAOStewardess implements DAO<Stewardess, Long>, DAOSuport {
    private static volatile DAOStewardess INSTANCE = null;
    private Map<String, PreparedStatement> pstMap;

    private static final String saveItemQuery = "INSERT INTO " + STEWARDESS_TABLE
            + " (NAME, LAST_NAME, FLY_LIST_ID) VALUES (?, ?, ?)";
    private static final String updateItemQuery = "UPDATE " + STEWARDESS_TABLE
            + " SET NAME=?, LAST_NAME=?, FLY_LIST_ID=? WHERE ID=?";
    private static final String getItemQuery = "SELECT * FROM " + STEWARDESS_TABLE
            + " WHERE ID=?";
    private static final String deleteItemQuery = "DELETE FROM " + STEWARDESS_TABLE
            + " WHERE ID=?";

    private DAOStewardess() {
    }

    public static DAOStewardess getInstance() {
        DAOStewardess dao = INSTANCE;
        if (dao == null) {
            synchronized (DAOStewardess.class) {
                dao = INSTANCE;
                if (dao == null) {
                    INSTANCE = dao = new DAOStewardess();
                }
            }
        }
        return dao;
    }

    @Override
    public Stewardess save(Stewardess stewardess) throws SQLException {
        PreparedStatement pst = pstMap.get("save");
        pst.setString(1, stewardess.getName());
        pst.setString(2, stewardess.getLastName());
        pst.setLong(3, stewardess.getFlyListId());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            stewardess.setId(rs.getLong(1));
        }
        rs.close();
        return stewardess;
    }

    @Override
    public Stewardess get(Long id) throws SQLException {
        Stewardess stewardess = new Stewardess();
        PreparedStatement pst = pstMap.get("get");
        pst.setLong(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        rs.next();
        stewardess.setId(rs.getLong("ID"));
        stewardess.setName(rs.getString("NAME"));
        stewardess.setLastName(rs.getString("LAST_NAME"));
        stewardess.setFlyListId(rs.getLong("FLY_LIST_ID"));
        rs.close();
        return stewardess;
    }

    @Override
    public void update(Stewardess stewardess) throws SQLException {
        PreparedStatement pst = pstMap.get("update");
        pst.setString(1, stewardess.getName());
        pst.setString(2, stewardess.getLastName());
        pst.setLong(3, stewardess.getFlyListId());
        pst.setLong(4, stewardess.getId());
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

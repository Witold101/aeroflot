package by.school.aeroflot.dao.implDao;

import by.school.aeroflot.dao.DAO;
import by.school.aeroflot.dao.DAOSuport;
import by.school.aeroflot.entities.Navigator;
import by.school.aeroflot.entities.RadioOperator;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static by.school.aeroflot.db.SQLQueryConstants.*;

public class DAORadioOperator implements DAO<RadioOperator,Long>, DAOSuport {

    private static volatile DAORadioOperator INSTANCE = null;

    private Map<String, PreparedStatement> pstMap;

    private static final String saveItemQuery = "INSERT INTO " + RADIOOPERATOR_TABLE
            + " (NAME, LAST_NAME, FLY_LIST_ID) VALUES (?, ?, ?)";
    private static final String updateItemQuery = "UPDATE " + RADIOOPERATOR_TABLE
            + " SET NAME=?, LAST_NAME=?, FLY_LIST_ID=? WHERE ID=?";
    private static final String getItemQuery = "SELECT * FROM " + RADIOOPERATOR_TABLE
            + " WHERE ID=?";
    private static final String deleteItemQuery = "DELETE FROM " + RADIOOPERATOR_TABLE
            + " WHERE ID=?";

    private DAORadioOperator() {
    }

    public static DAORadioOperator getInstance() {
        DAORadioOperator dao = INSTANCE;
        if (dao == null) {
            synchronized (DAORadioOperator.class) {
                dao = INSTANCE;
                if (dao == null) {
                    INSTANCE = dao = new DAORadioOperator();
                }
            }
        }
        return dao;
    }

    @Override
    public RadioOperator save(RadioOperator radioOperator) throws SQLException {
        PreparedStatement pst = pstMap.get("save");
        pst.setString(1, radioOperator.getName());
        pst.setString(2, radioOperator.getLastName());
        pst.setLong(3,radioOperator.getFlyListId());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            radioOperator.setId(rs.getLong(1));
        }
        rs.close();
        return radioOperator;
    }

    @Override
    public RadioOperator get(Long id) throws SQLException {
        RadioOperator radioOperator = new RadioOperator();
        PreparedStatement pst = pstMap.get("get");
        pst.setLong(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        rs.next();
        radioOperator.setId(rs.getLong("ID"));
        radioOperator.setName(rs.getString("NAME"));
        radioOperator.setLastName(rs.getString("LAST_NAME"));
        radioOperator.setFlyListId(rs.getLong("FLY_LIST_ID"));
        rs.close();
        return radioOperator;
    }

    @Override
    public void update(RadioOperator radioOperator) throws SQLException {
        PreparedStatement pst = pstMap.get("update");
        pst.setString(1, radioOperator.getName());
        pst.setString(2, radioOperator.getLastName());
        pst.setLong(3, radioOperator.getFlyListId());
        pst.setLong(4, radioOperator.getId());
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

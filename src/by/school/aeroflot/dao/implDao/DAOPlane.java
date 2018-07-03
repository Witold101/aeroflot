package by.school.aeroflot.dao.implDao;

import by.school.aeroflot.dao.DAO;
import by.school.aeroflot.dao.DAOSuport;
import by.school.aeroflot.entities.Plane;
import by.school.aeroflot.entities.Team;
import by.school.aeroflot.exceptions.InfoException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static by.school.aeroflot.db.SQLQueryConstants.*;

public class DAOPlane implements DAO<Plane, Long>, DAOSuport {
    private static volatile DAOPlane INSTANCE = null;
    private Map<String, PreparedStatement> pstMap;

    private static final String saveItemQuery = "INSERT INTO " + PLANE_TABLE
            + " (MODEL, CAPACITY, FLYING_RANGE, FLY_LIST_ID) VALUES (?, ?, ?, ?)";
    private static final String getItemQuery = "SELECT * FROM " + PLANE_TABLE
            + " WHERE ID=?";
    private static final String updateItemQuery = "UPDATE " + PLANE_TABLE
            + " SET MODEL=?, CAPACITY=?, FLYING_RANGE=?, FLY_LIST_ID=? WHERE ID=?";
    private static final String deleteItemQuery = "DELETE FROM " + PLANE_TABLE
            + " WHERE ID=?";

    private DAOPlane() {
    }

    public static DAOPlane getInstance() {
        DAOPlane dao = INSTANCE;
        if (dao == null) {
            synchronized (DAOPlane.class) {
                dao = INSTANCE;
                if (dao == null) {
                    INSTANCE = dao = new DAOPlane();
                }
            }
        }
        return dao;
    }

    @Override
    public Plane save(Plane plane) throws SQLException {
        PreparedStatement pst = pstMap.get("save");
        pst.setString(1, plane.getModel());
        pst.setInt(2, plane.getCapacity());
        pst.setInt(3, plane.getFlyingRange());
        pst.setLong(4, plane.getFlyListId());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            plane.setId(rs.getLong(1));
        }
        rs.close();
        return plane;
    }

    @Override
    public Plane get(Long id) throws SQLException {
        Plane plane = new Plane();
        PreparedStatement pst = pstMap.get("get");
        pst.setLong(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        rs.next();
        plane.setId(rs.getLong("ID"));
        plane.setModel(rs.getString("MODEL"));
        plane.setCapacity(rs.getInt("CAPACITY"));
        plane.setFlyingRange(rs.getInt("FLYING_RANGE"));
        plane.setFlyListId(rs.getLong("FLY_LIST_ID"));
        rs.close();
        return plane;
    }

    @Override
    public void update(Plane plane) throws SQLException {
        PreparedStatement pst = pstMap.get("update");
        pst.setString(1, plane.getModel());
        pst.setInt(2, plane.getCapacity());
        pst.setInt(3, plane.getFlyingRange());
        pst.setLong(4, plane.getFlyListId());
        pst.setLong(5, plane.getId());
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

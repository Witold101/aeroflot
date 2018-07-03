package by.school.aeroflot.dao.implDao;

import by.school.aeroflot.dao.DAO;
import by.school.aeroflot.dao.DAOSuport;
import by.school.aeroflot.entities.Administrator;
import by.school.aeroflot.entities.Airport;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static by.school.aeroflot.db.SQLQueryConstants.AIRPORT_TABLE;

public class DAOAirport implements DAO<Airport,Long>, DAOSuport {

    private static volatile DAOAirport INSTANCE = null;
    private Map<String, PreparedStatement> pstMap;

    private static final String saveItemQuery = "INSERT INTO " + AIRPORT_TABLE
            + " (NAME, FLYING_WEATHER) VALUES (?, ?)";
    private static final String updateItemQuery = "UPDATE " + AIRPORT_TABLE
            + " SET NAME=?, FLYING_WEATHER=? WHERE ID=?";
    private static final String getItemQuery = "SELECT * FROM " + AIRPORT_TABLE
            + " WHERE ID=?";
    private static final String deleteItemQuery = "DELETE FROM " + AIRPORT_TABLE
            + " WHERE ID=?";

    private DAOAirport() {
    }

    public static DAOAirport getInstance() {
        DAOAirport dao = INSTANCE;
        if (dao == null) {
            synchronized (DAOAirport.class) {
                dao = INSTANCE;
                if (dao == null) {
                    INSTANCE = dao = new DAOAirport();
                }
            }
        }
        return dao;
    }

    @Override
    public Airport save(Airport airport) throws SQLException {
        PreparedStatement pst = pstMap.get("save");
        pst.setString(1, airport.getName());
        pst.setBoolean(2, airport.isFlyingWeather());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            airport.setId(rs.getLong(1));
        }
        rs.close();
        return airport;
    }

    @Override
    public Airport get(Long id) throws SQLException {
        Airport airport = new Airport();
        PreparedStatement pst = pstMap.get("get");
        pst.setLong(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        rs.next();
        airport.setId(rs.getLong("ID"));
        airport.setName(rs.getString("NAME"));
        airport.setFlyingWeather(rs.getBoolean("FLYING_WEATHER"));
        rs.close();
        return airport;
    }

    @Override
    public void update(Airport airport) throws SQLException {
        PreparedStatement pst = pstMap.get("update");
        pst.setString(1, airport.getName());
        pst.setBoolean(2, airport.isFlyingWeather());
        pst.setLong(3, airport.getId());
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

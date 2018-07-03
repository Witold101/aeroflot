package by.school.aeroflot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public interface DAOSuport {
    void initPreparedStatement(Connection connection) throws SQLException;
    void closePreparedStatement() throws SQLException;
}

package by.school.aeroflot.services.impl;

import by.school.aeroflot.db.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ServiceAbstract {
    private Connection connection;

    public ServiceAbstract(Connection connection) {
        this.connection = connection;
    }

    public void startTransaction() throws SQLException {
        this.connection.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        this.connection.commit();
    }

    public abstract void closePreparedStatement();

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            System.out.println("Error close Connection in Service");
            e.printStackTrace();
        }
    }
}

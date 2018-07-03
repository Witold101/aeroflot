package by.school.aeroflot.services.impl;

import by.school.aeroflot.dao.implDao.DAOAdministrator;
import by.school.aeroflot.dao.implDao.DAOAirport;
import by.school.aeroflot.entities.Administrator;
import by.school.aeroflot.entities.Airport;
import by.school.aeroflot.services.EntitiesServices;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Класс для валидации DAO Airport при инициализации класса происходит загрузка
 * PreparedStatement
 * После отработки требуется закрытие PreparedStatement и Connection
 */

public class ServiceAirport extends ServiceAbstract implements EntitiesServices<Airport,Long> {

    DAOAirport daoAirport = DAOAirport.getInstance();

    public ServiceAirport(Connection connection) {
        super(connection);
        try {
            daoAirport.initPreparedStatement(connection);
        } catch (SQLException e) {
            System.out.println("Error init PreparedStatement in ServiceAirport");
            e.printStackTrace();
        }
    }

    @Override
    public Airport save(Airport t) {
        if (t != null) {
            try {
                startTransaction();
                daoAirport.save(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error save Airport Item in DB");
                e.printStackTrace();
            }
        }
        return t;
    }

    @Override
    public Airport get(Long id) {
        Airport airport = null;
        if (id != null) {
            try {
                startTransaction();
                airport = daoAirport.get(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error get Airport Item in DB");
                e.printStackTrace();
            }
        }
        return airport;
    }

    @Override
    public void update(Airport t) {
        if (t != null) {
            try {
                startTransaction();
                daoAirport.update(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error update Airport Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null){
            try {
                startTransaction();
                daoAirport.delete(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error delete Airport Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement() {
        try {
            daoAirport.closePreparedStatement();
        } catch (SQLException e) {
            System.out.println("Error close PreparedStatement in ServiceAirport");
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            System.out.println("Error close Connection in ServiceAirport");
            e.printStackTrace();
        }
    }
}

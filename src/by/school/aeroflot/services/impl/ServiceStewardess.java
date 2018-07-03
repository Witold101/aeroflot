package by.school.aeroflot.services.impl;

import by.school.aeroflot.dao.implDao.DAONavigator;
import by.school.aeroflot.dao.implDao.DAOStewardess;
import by.school.aeroflot.entities.Navigator;
import by.school.aeroflot.entities.Stewardess;
import by.school.aeroflot.services.EntitiesServices;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceStewardess extends ServiceAbstract implements EntitiesServices<Stewardess,Long> {

    private DAOStewardess daoStewardess = DAOStewardess.getInstance();

    public ServiceStewardess(Connection connection) {
        super(connection);
        try {
            daoStewardess.initPreparedStatement(connection);
        } catch (SQLException e) {
            System.out.println("Error init PreparedStatement in ServiceStewardess");
            e.printStackTrace();
        }
    }

    @Override
    public Stewardess save(Stewardess t) {
        if (t != null) {
            try {
                startTransaction();
                daoStewardess.save(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error save Stewardess Item in DB");
                e.printStackTrace();
            }
        }return t;
    }

    @Override
    public Stewardess get(Long id) {
        Stewardess stewardess = null;
        if (id != null) {
            try {
                startTransaction();
                stewardess = daoStewardess.get(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error get Stewardess Item in DB");
                e.printStackTrace();
            }
        }
        return stewardess;
    }

    @Override
    public void update(Stewardess t) {
        if (t != null) {
            try {
                startTransaction();
                daoStewardess.update(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error update Stewardess Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null){
            try {
                startTransaction();
                daoStewardess.delete(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error delete Stewardess Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement() {
        try {
            daoStewardess.closePreparedStatement();
        } catch (SQLException e) {
            System.out.println("Error close PreparedStatement in ServiceStewardess");
            e.printStackTrace();
        }
    }
}

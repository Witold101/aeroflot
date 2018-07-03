package by.school.aeroflot.services.impl;

import by.school.aeroflot.dao.implDao.DAONavigator;
import by.school.aeroflot.dao.implDao.DAOTeam;
import by.school.aeroflot.entities.Navigator;
import by.school.aeroflot.entities.Team;
import by.school.aeroflot.services.EntitiesServices;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceNavigator extends ServiceAbstract implements EntitiesServices<Navigator,Long> {

    private DAONavigator daoNavigator = DAONavigator.getInstance();

    public ServiceNavigator(Connection connection) {
        super(connection);
        try {
            daoNavigator.initPreparedStatement(connection);
        } catch (SQLException e) {
            System.out.println("Error init PreparedStatement in ServiceNavigator");
            e.printStackTrace();
        }
    }

    @Override
    public Navigator save(Navigator t) {
        if (t != null) {
            try {
                startTransaction();
                daoNavigator.save(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error save Navigator Item in DB");
                e.printStackTrace();
            }
        }return t;
    }

    @Override
    public Navigator get(Long id) {
        Navigator navigator = null;
        if (id != null) {
            try {
                startTransaction();
                navigator = daoNavigator.get(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error get Navigator Item in DB");
                e.printStackTrace();
            }
        }
        return navigator;
    }

    @Override
    public void update(Navigator t) {
        if (t != null) {
            try {
                startTransaction();
                daoNavigator.update(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error update Navigator Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null){
            try {
                startTransaction();
                daoNavigator.delete(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error delete Navigator Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement() {
        try {
            daoNavigator.closePreparedStatement();
        } catch (SQLException e) {
            System.out.println("Error close PreparedStatement in ServiceNavigator");
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            System.out.println("Error close Connection in ServiceNavigator");
            e.printStackTrace();
        }
    }
}

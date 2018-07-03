package by.school.aeroflot.services.impl;

import by.school.aeroflot.dao.implDao.DAONavigator;
import by.school.aeroflot.dao.implDao.DAOPilot;
import by.school.aeroflot.entities.Navigator;
import by.school.aeroflot.entities.Pilot;
import by.school.aeroflot.services.EntitiesServices;

import java.sql.Connection;
import java.sql.SQLException;

public class ServicePilot extends ServiceAbstract implements EntitiesServices<Pilot,Long> {

    private DAOPilot daoPilot = DAOPilot.getInstance();

    public ServicePilot(Connection connection) {
        super(connection);
        try {
            daoPilot.initPreparedStatement(connection);
        } catch (SQLException e) {
            System.out.println("Error init PreparedStatement in ServicePilot");
            e.printStackTrace();
        }
    }

    @Override
    public Pilot save(Pilot t) {
        if (t != null) {
            try {
                startTransaction();
                daoPilot.save(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error save Pilot Item in DB");
                e.printStackTrace();
            }
        }return t;
    }

    @Override
    public Pilot get(Long id) {
        Pilot pilot = null;
        if (id != null) {
            try {
                startTransaction();
                pilot = daoPilot.get(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error get Pilot Item in DB");
                e.printStackTrace();
            }
        }
        return pilot;
    }

    @Override
    public void update(Pilot t) {
        if (t != null) {
            try {
                startTransaction();
                daoPilot.update(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error update Pilot Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null){
            try {
                startTransaction();
                daoPilot.delete(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error delete Pilot Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement() {
        try {
            daoPilot.closePreparedStatement();
        } catch (SQLException e) {
            System.out.println("Error close PreparedStatement in ServicePilot");
            e.printStackTrace();
        }
    }
}

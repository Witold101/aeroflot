package by.school.aeroflot.services.impl;

import by.school.aeroflot.dao.implDao.DAOPlane;
import by.school.aeroflot.dao.implDao.DAOTeam;
import by.school.aeroflot.entities.Plane;
import by.school.aeroflot.entities.Team;
import by.school.aeroflot.services.EntitiesServices;

import java.sql.Connection;
import java.sql.SQLException;

public class ServicePlane extends ServiceAbstract implements EntitiesServices<Plane, Long> {

    DAOPlane daoPlane = DAOPlane.getInstance();

    public ServicePlane(Connection connection) {
        super(connection);
        try {
            daoPlane.initPreparedStatement(connection);
        } catch (SQLException e) {
            System.out.println("Error init PreparedStatement in ServicePlane");
            e.printStackTrace();
        }
    }

    @Override
    public Plane save(Plane t) {
        if (t != null) {
            try {
                startTransaction();
                daoPlane.save(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error save Plane Item in DB");
                e.printStackTrace();
            }
        }
        return t;
    }

    @Override
    public Plane get(Long id) {
        Plane plane = null;
        if (id != null) {
            try {
                startTransaction();
                plane = daoPlane.get(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error get Plane Item in DB");
                e.printStackTrace();
            }
        }
        return plane;
    }

    @Override
    public void update(Plane t) {
        if (t != null) {
            try {
                startTransaction();
                daoPlane.update(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error update Plane Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            try {
                startTransaction();
                daoPlane.delete(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error delete Plane Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement() {
        try {
            daoPlane.closePreparedStatement();
        } catch (SQLException e) {
            System.out.println("Error close PreparedStatement in ServicePlane");
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            System.out.println("Error close Connection in ServicePlane");
            e.printStackTrace();
        }
    }
}

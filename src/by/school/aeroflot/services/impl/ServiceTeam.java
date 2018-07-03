package by.school.aeroflot.services.impl;

import by.school.aeroflot.dao.implDao.DAOAirport;
import by.school.aeroflot.dao.implDao.DAOTeam;
import by.school.aeroflot.entities.Airport;
import by.school.aeroflot.entities.Team;
import by.school.aeroflot.services.EntitiesServices;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceTeam extends ServiceAbstract implements EntitiesServices<Team, Long> {

    private DAOTeam daoTeam = DAOTeam.getInstance();

    public ServiceTeam(Connection connection) {
        super(connection);
        try {
            daoTeam.initPreparedStatement(connection);
        } catch (SQLException e) {
            System.out.println("Error init PreparedStatement in ServiceTeam");
            e.printStackTrace();
        }
    }

    @Override
    public Team save(Team t) {
        if (t != null) {
            try {
                startTransaction();
                daoTeam.save(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error save Team Item in DB");
                e.printStackTrace();
            }
        }
        return t;
    }

    @Override
    public Team get(Long id) {
        Team team = null;
        if (id != null) {
            try {
                startTransaction();
                team = daoTeam.get(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error get Team Item in DB");
                e.printStackTrace();
            }
        }
        return team;
    }

    @Override
    public void update(Team t) {
        if (t != null) {
            try {
                startTransaction();
                daoTeam.update(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error update Team Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            try {
                startTransaction();
                daoTeam.delete(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error delete Team Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement() {
        try {
            daoTeam.closePreparedStatement();
        } catch (SQLException e) {
            System.out.println("Error close PreparedStatement in ServiceTeam");
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            System.out.println("Error close Connection in ServiceTeam");
            e.printStackTrace();
        }
    }
}

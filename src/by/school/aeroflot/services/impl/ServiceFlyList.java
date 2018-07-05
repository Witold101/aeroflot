package by.school.aeroflot.services.impl;

import by.school.aeroflot.dao.implDao.DAOFlyList;
import by.school.aeroflot.entities.FlyList;
import by.school.aeroflot.services.EntitiesServices;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceFlyList extends ServiceAbstract implements EntitiesServices<FlyList,Long> {

    private DAOFlyList daoFlyList = DAOFlyList.getInstance();

    public ServiceFlyList(Connection connection) {
        super(connection);
        try {
            daoFlyList.initPreparedStatement(connection);
        } catch (SQLException e) {
            System.out.println("Error init PreparedStatement in ServiceFlyList");
            e.printStackTrace();
        }
    }

    @Override
    public FlyList save(FlyList t) {
        if (t != null) {
            try {
                startTransaction();
                daoFlyList.save(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error save FlyList Item in DB");
                e.printStackTrace();
            }
        }
        return t;
    }

    @Override
    public FlyList get(Long id) {
        FlyList flyList = null;
        if (id != null) {
            try {
                startTransaction();
                flyList = daoFlyList.get(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error get FlyList Item in DB");
                e.printStackTrace();
            }
        }
        return flyList;
    }

    @Override
    public void update(FlyList t) {
        if (t != null) {
            try {
                startTransaction();
                daoFlyList.update(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error update FlyList Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null){
            try {
                startTransaction();
                daoFlyList.delete(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error delete FlyList Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement() {
        try {
            daoFlyList.closePreparedStatement();
        } catch (SQLException e) {
            System.out.println("Error close PreparedStatement in ServiceFlyList");
            e.printStackTrace();
        }
    }
}

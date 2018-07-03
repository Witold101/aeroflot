package by.school.aeroflot.services.impl;

import by.school.aeroflot.dao.implDao.DAONavigator;
import by.school.aeroflot.dao.implDao.DAORadioOperator;
import by.school.aeroflot.entities.Navigator;
import by.school.aeroflot.entities.RadioOperator;
import by.school.aeroflot.services.EntitiesServices;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceRadioOperator extends ServiceAbstract implements EntitiesServices<RadioOperator,Long> {

    private DAORadioOperator daoRadioOperator = DAORadioOperator.getInstance();

    public ServiceRadioOperator(Connection connection) {
        super(connection);
        try {
            daoRadioOperator.initPreparedStatement(connection);
        } catch (SQLException e) {
            System.out.println("Error init PreparedStatement in ServiceRadiooperator");
            e.printStackTrace();
        }
    }

    @Override
    public RadioOperator save(RadioOperator t) {
        if (t != null) {
            try {
                startTransaction();
                daoRadioOperator.save(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error save RadioOperator Item in DB");
                e.printStackTrace();
            }
        }return t;
    }

    @Override
    public RadioOperator get(Long id) {
        RadioOperator radioOperator = null;
        if (id != null) {
            try {
                startTransaction();
                radioOperator = daoRadioOperator.get(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error get RadioOperator Item in DB");
                e.printStackTrace();
            }
        }
        return radioOperator;
    }

    @Override
    public void update(RadioOperator t) {
        if (t != null) {
            try {
                startTransaction();
                daoRadioOperator.update(t);
                commit();
            } catch (SQLException e) {
                System.out.println("Error update RadioOperator Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null){
            try {
                startTransaction();
                daoRadioOperator.delete(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error delete RadioOperator Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement() {
        try {
            daoRadioOperator.closePreparedStatement();
        } catch (SQLException e) {
            System.out.println("Error close PreparedStatement in ServiceRadioOperator");
            e.printStackTrace();
        }
    }
}

package by.school.aeroflot.services.impl;

import by.school.aeroflot.dao.implDao.DAOAdministrator;
import by.school.aeroflot.entities.Administrator;
import by.school.aeroflot.services.EntitiesServices;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Класс для валидации DAO Administrator при инициализации класса происходит загрузка
 * PreparedStatement
 * После отработки требуется закрытие PreparedStatement и Connection
 */
public class ServiceAdministrator extends ServiceAbstract implements EntitiesServices<Administrator, Long> {

    DAOAdministrator daoAdministrator = DAOAdministrator.getInstance();

    public ServiceAdministrator(Connection connection) {
        super(connection);
        try {
            daoAdministrator.initPreparedStatement(connection);
        } catch (SQLException e) {
            System.out.println("Error init PreparedStatement in ServiceAdministrator");
            e.printStackTrace();
        }
    }

    @Override
    public void closePreparedStatement() {
        try {
            daoAdministrator.closePreparedStatement();
        } catch (SQLException e) {
            System.out.println("Error close PreparedStatement in ServiceAdministrator");
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            System.out.println("Error close Connection in ServiceAdministrator");
            e.printStackTrace();
        }
    }

    @Override
    public Administrator save(Administrator administrator) {
        if (administrator != null) {
            try {
                startTransaction();
                daoAdministrator.save(administrator);
                commit();
            } catch (SQLException e) {
                System.out.println("Error save Administrator Item in DB");
                e.printStackTrace();
            }
        }
        return administrator;
    }

    @Override
    public Administrator get(Long id) {
        Administrator administrator = null;
        if (id != null) {
            try {
                startTransaction();
                administrator = daoAdministrator.get(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error get Administrator Item in DB");
                e.printStackTrace();
            }
        }
        return administrator;
    }

    @Override
    public void update(Administrator administrator) {
        if (administrator != null) {
            try {
                startTransaction();
                daoAdministrator.update(administrator);
                commit();
            } catch (SQLException e) {
                System.out.println("Error update Administrator Item in DB");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null){
            try {
                startTransaction();
                daoAdministrator.delete(id);
                commit();
            } catch (SQLException e) {
                System.out.println("Error delete Administrator Item in DB");
                e.printStackTrace();
            }
        }
    }
}

package by.school.aeroflot;

import by.school.aeroflot.db.DbConnection;
import by.school.aeroflot.entities.Administrator;
import by.school.aeroflot.entities.Airport;
import by.school.aeroflot.services.impl.ServiceAdministrator;
import by.school.aeroflot.services.impl.ServiceAirport;

import java.sql.*;

/**
 * 10.	Система Аэрофлот. Администратор формирует летную Бригаду (пилоты, штурман, радист, стюардессы)
 * на Рейс.Каждый Рейс выполняется Самолетом с определенной вместимостью и дальностью полета. Рейс
 * может быть отменен из-за погодных условий в Аэропорту отлета или назначения. Аэропорт назначения
 * может быть изменен в полете из-за технических неисправностей, о которых сообщил командир.
 */

public class Start {
    public static void main(String[] args) {

//        Connection connection = DbConnection.getConnection();
//        DatabaseMetaData metaData = connection.getMetaData();
//
//        System.out.println(metaData.getDriverName());
//        System.out.println(metaData.getDriverVersion());
//        System.out.println(metaData.getUserName());
//        System.out.println(metaData.getURL());
//
//        connection.close();

        System.out.println("--------------------------------------------");


//        EquipmentCRUD crud = new EquipmentCRUD();
//        System.out.println(crud.addRecord("646474"));
//        System.out.println(crud.dellRecordOnID(3));

        Airport airport = new Airport();
        airport.setId(5);
        airport.setName("Bob");
        airport.setFlyingWeather(false);
        ServiceAirport sAir = null;
        try {
            sAir = new ServiceAirport(DbConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        sAir.delete(5L);

    //        sAdmin.update(administrator);
    //    sAir.save(airport);
   //     administrator = sAdmin.get(14L);

        sAir.closePreparedStatement();
        sAir.closeConnection();

        //List<Administrator> list = daoAdministrator.getAll();
//        daoAdministrator.add(administrator);
        //administrator = daoAdministrator.getEntityById(14L);
//        daoAdministrator.delete(18L);
//        administrator.setLastName("Redod");
//        daoAdministrator.update(administrator);

    }

}

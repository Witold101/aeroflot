package by.school.aeroflot.db;

import static by.school.aeroflot.db.SQLQueryConstants.*;

public class InitDate {
    public static final String DATE_PLANE_TABLE =
            "INSERT INTO `db_aeroflot`.`plane_table` (`ID`, `MODEL`) VALUES (1, 'Airbus A320');\n" +
            "INSERT INTO `db_aeroflot`.`plane_table` (`ID`, `MODEL`) VALUES (2, 'Airbus A330');\n" +
            "INSERT INTO `db_aeroflot`.`plane_table` (`ID`, `MODEL`) VALUES (3, 'Boeing-737');\n" +
            "INSERT INTO `db_aeroflot`.`plane_table` (`ID`, `MODEL`) VALUES (4, 'Boeing-747');\n" +
            "INSERT INTO `db_aeroflot`.`plane_table` (`ID`, `MODEL`) VALUES (5, 'Boeing-767');\n" +
            "INSERT INTO `db_aeroflot`.`plane_table` (`ID`, `MODEL`) VALUES (6, 'Boeing-777');";

    public static final String DATE_ADMINISTRATOR_TABLE =
            "INSERT INTO `db_aeroflot`.`"+ADMINISTRATOR_TABLE+"` (`ID`,`NAME`, `LAST_NAME`) VALUES (1,'Иван','Иванов');\n" +
            "INSERT INTO `db_aeroflot`.`"+ADMINISTRATOR_TABLE+"` (`ID`,`NAME`, `LAST_NAME`) VALUES (2,'Алексей','Сидоров');\n" +
            "INSERT INTO `db_aeroflot`.`"+ADMINISTRATOR_TABLE+"` (`ID`,`NAME`, `LAST_NAME`) VALUES (3,'Андрей','Смернов');\n" +
            "INSERT INTO `db_aeroflot`.`"+ADMINISTRATOR_TABLE+"` (`ID`,`NAME`, `LAST_NAME`) VALUES (4,'Анна','Иванюк');";

    public static final String DATE_NAVIGATOR_TABLE =
            "INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (1,'Александр','Нрков');\n" +
            "INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (2,'Сергей','Чалый');\n" +
            "INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (3,'Ольга','Новикова');\n" +
            "INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (4,'Александр','Бурков');\n" +
            "INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (5,'Иван','Мокин');\n" +
            "INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (6,'Евгений','Ботов');";

    public static final String DATE_EQUIPMENT_TABLE =
            "INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (1,'Гирокомпас');\n" +
            "INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (2,'Радиопеленгатор');\n" +
            "INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (3,'Гидролокатор');\n" +
            "INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (4,'Радиодальномер');\n" +
            "INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (5,'Высотомер');\n";

    public static final String DATE_AIRPORT_TABLE =
            "INSERT INTO `db_aeroflot`.`"+AIRPORT_TABLE+"` (`NAME`, `FLYING_WEATHER`) VALUES ('Vancouver International Airport',TRUE);\n" +
            "INSERT INTO `db_aeroflot`.`"+AIRPORT_TABLE+"` (`NAME`, `FLYING_WEATHER`) VALUES ('Moscow Sheremetyevo Airport',TRUE);\n" +
            "INSERT INTO `db_aeroflot`.`"+AIRPORT_TABLE+"` (`NAME`, `FLYING_WEATHER`) VALUES ('Sydney Airport',TRUE);\n" +
            "INSERT INTO `db_aeroflot`.`"+AIRPORT_TABLE+"` (`NAME`, `FLYING_WEATHER`) VALUES ('Hong Kong International Airport',TRUE);";



}

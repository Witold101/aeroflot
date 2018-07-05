package by.school.aeroflot.db;

public class SQLQueryConstants {

    public static final String GET_DATE_ON_ID = "select * from administrator_table where ID=?;";


// -------------------------- TABLES NAME --------------------------------------
    public static final String ADMINISTRATOR_TABLE = "ADMINISTRATOR_TABLE";
    public static final String NAVIGATOR_TABLE = "NAVIGATOR_TABLE";
    public static final String AIRPORT_TABLE = "AIRPORT_TABLE";
    public static final String PILOT_TABLE = "PILOT_TABLE";
    public static final String PLANE_TABLE = "PLANE_TABLE";
    public static final String TEAM_TABLE = "TEAM_TABLE";
    public static final String RADIOOPERATOR_TABLE = "RADIOOPERATOR_TABLE";
    public static final String FLY_LiST_TABLE = "FLY_LiST_TABLE";
    public static final String QUALIFICATION = "QUALIFICATION";
    public static final String STEWARDESS_TABLE = "STEWARDESS_TABLE";
//-------------------------------------------------------------------------------
//-------------------------- TABLES COL -----------------------------------------
    public static final String RADIOOPERATOR ="FK_RADIOOPERATOR_ID";
    public static final String NAVIGATOR ="FK_NAVIGATOR_ID";

//-------------------------------------------------------------------------------

}

package by.school.aeroflot.db;

public class InitDB {
    public static final String BUILD_DB_AEROFLOT =
            "CREATE DATABASE  IF NOT EXISTS `db_aeroflot` DEFAULT CHARACTER SET utf8";

    public static final String ADMINISTRATOR_TABLE =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`ADMINISTRATOR_TABLE` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `NAME` VARCHAR(50) NOT NULL,\n" +
            "  `LAST_NAME` VARCHAR(50) NULL DEFAULT NULL,\n" +
            "  PRIMARY KEY (`ID`))\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String NAVIGATOR_TABLE =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`NAVIGATOR_TABLE` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `NAME` VARCHAR(50) NOT NULL,\n" +
            "  `LAST_NAME` VARCHAR(50) NULL DEFAULT NULL,\n" +
            "  PRIMARY KEY (`ID`))\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String EQUIPMENT_TABLE =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`EQUIPMENT_TABLE` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `NAME` VARCHAR(50) NOT NULL,\n" +
            "  PRIMARY KEY (`ID`))\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;\n";

    public static final String NAVIGATOR_EQUIPMENT =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`NAVIGATOR_EQUIPMENT` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `NAVIGATOR_ID` INT(11) NOT NULL,\n" +
            "  `EQUIPMENT_ID` INT(11) NOT NULL,\n" +
            "  PRIMARY KEY (`ID`),\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String PILOT_TABLE =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`PILOT_TABLE` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `NAME` VARCHAR(50) NOT NULL,\n" +
            "  `LAST_NAME` VARCHAR(50) NULL DEFAULT NULL,\n" +
            "  PRIMARY KEY (`ID`))\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String PLANE_TABLE =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`PLANE_TABLE` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `MODEL` VARCHAR(50) NOT NULL,\n" +
            "  PRIMARY KEY (`ID`))\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String PILOT_PLANE =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`PILOT_PLANE` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `PILOT_ID` INT(11) NOT NULL,\n" +
            "  `PLANE_ID` INT(11) NOT NULL,\n" +
            "  PRIMARY KEY (`ID`),\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String RADIOOPERATOR_TABLE =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`RADIOOPERATOR_TABLE` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `NAME` VARCHAR(50) NOT NULL,\n" +
            "  `LAST_NAME` VARCHAR(50) NULL DEFAULT NULL,\n" +
            "  PRIMARY KEY (`ID`))\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String RADIOOPERATOR_EQUIPMENT =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`RADIOOPERATOR_EQUIPMENT` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `RADIOOPERATOR_ID` INT(11) NOT NULL,\n" +
            "  `EQUIPMENT_ID` INT(11) NOT NULL,\n" +
            "  PRIMARY KEY (`ID`),\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String RADIOOPERATOR_PLANE =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`RADIOOPERATOR_PLANE` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `RADIOOPERATOR_ID` INT(11) NOT NULL,\n" +
            "  `PLANE_ID` INT(11) NOT NULL,\n" +
            "  PRIMARY KEY (`ID`),\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String QUALIFICATION =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`QUALIFICATION` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `LEVEL` INT(11) NOT NULL,\n" +
            "  PRIMARY KEY (`ID`))\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";

    public static final String STEWARDESS_TABLE =
            "CREATE TABLE IF NOT EXISTS `db_aeroflot`.`STEWARDESS_TABLE` (\n" +
            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `NAME` VARCHAR(50) NOT NULL,\n" +
            "  `LAST_NAME` VARCHAR(50) NULL DEFAULT NULL,\n" +
            "  `QUALIFICATION_ID` INT(11) NOT NULL,\n" +
            "  PRIMARY KEY (`ID`),\n" +
            "  INDEX `FK_QUALIFICATION_idx` (`QUALIFICATION_ID` ASC),\n" +
            "  CONSTRAINT `FK_QUALIFICATION`\n" +
            "    FOREIGN KEY (`QUALIFICATION_ID`)\n" +
            "    REFERENCES `db_aeroflot`.`QUALIFICATION` (`ID`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8\n" +
            "COLLATE = utf8_bin;";
}

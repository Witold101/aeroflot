INSERT INTO `db_aeroflot`.`plane_table` (MODEL, CAPACITY, FLYING_RANGE) VALUES ('Airbus A320',10,10);
INSERT INTO `db_aeroflot`.`plane_table` (MODEL, CAPACITY, FLYING_RANGE) VALUES ('Airbus A330',10,10);
INSERT INTO `db_aeroflot`.`plane_table` (MODEL, CAPACITY, FLYING_RANGE) VALUES ('Boeing-737',10,10);
INSERT INTO `db_aeroflot`.`plane_table` (MODEL, CAPACITY, FLYING_RANGE) VALUES ('Boeing-747',10,10);
INSERT INTO `db_aeroflot`.`plane_table` (MODEL, CAPACITY, FLYING_RANGE) VALUES ('Boeing-767',10,10);
INSERT INTO `db_aeroflot`.`plane_table` (MODEL, CAPACITY, FLYING_RANGE) VALUES ('Boeing-777',10,10);
//------------------------------------------------------------------------------
INSERT INTO `db_aeroflot`.`administrator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (1,'Иван','Иванов');
INSERT INTO `db_aeroflot`.`administrator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (2,'Алексей','Сидоров');
INSERT INTO `db_aeroflot`.`administrator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (3,'Андрей','Смернов');
INSERT INTO `db_aeroflot`.`administrator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (4,'Анна','Иванюк');
//------------------------------------------------------------------------------
INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (1,'Александр','Нрков');
INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (2,'Сергей','Чалый');
INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (3,'Ольга','Новикова');
INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (4,'Александр','Бурков');
INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (5,'Иван','Мокин');
INSERT INTO `db_aeroflot`.`navigator_table` (`ID`,`NAME`, `LAST_NAME`) VALUES (6,'Евгений','Ботов');
//--------------------------------------------------------------------------------------------------
INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (1,'Гирокомпас');
INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (2,'Радиопеленгатор');
INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (3,'Гидролокатор');
INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (4,'Радиодальномер');
INSERT INTO `db_aeroflot`.`equipment_table` (`ID`,`NAME`) VALUES (5,'Высотомер');
//-------------------------------------------------------------------------------------------------
INSERT INTO `db_aeroflot`.`airport_table` (`NAME`, `FLYING_WEATHER`) VALUES ('Vancouver International Airport',TRUE);
INSERT INTO `db_aeroflot`.`airport_table` (`NAME`, `FLYING_WEATHER`) VALUES ('Moscow Sheremetyevo Airport',TRUE);
INSERT INTO `db_aeroflot`.`airport_table` (`NAME`, `FLYING_WEATHER`) VALUES ('Sydney Airport',TRUE);
INSERT INTO `db_aeroflot`.`airport_table` (`NAME`, `FLYING_WEATHER`) VALUES ('Hong Kong International Airport',TRUE);
-----------------------------------------------------------------------------------------------------
insert into team_table (ID, PILOT, RADIOOPERATOR, NAVIGATOR, STEWARDESS) value (9,1,1,0,3);
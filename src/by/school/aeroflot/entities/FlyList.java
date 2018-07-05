package by.school.aeroflot.entities;

import java.util.Calendar;
import java.sql.*;

public class FlyList {
    private Long id;
    private Date date;
    private Long airportStartId;
    private Long airportFinishId;
    private Long administratorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAirportStartId() {
        return airportStartId;
    }

    public void setAirportStartId(Long airportStartId) {
        this.airportStartId = airportStartId;
    }

    public Long getAirportFinishId() {
        return airportFinishId;
    }

    public void setAirportFinishId(Long airportFinishId) {
        this.airportFinishId = airportFinishId;
    }

    public Long getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Long administratorId) {
        this.administratorId = administratorId;
    }
}

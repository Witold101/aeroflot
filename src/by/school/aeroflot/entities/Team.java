package by.school.aeroflot.entities;

/**
 * Класс описывает количество членов команды для управления самолетом.
 */

public class Team {
    private Long id;
    private int pilot;
    private int radiooperator;
    private int navigator;
    private int stewardess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public int getRadiooperator() {
        return radiooperator;
    }

    public void setRadiooperator(int radiooperator) {
        this.radiooperator = radiooperator;
    }

    public int getNavigator() {
        return navigator;
    }

    public void setNavigator(int navigator) {
        this.navigator = navigator;
    }

    public int getStewardess() {
        return stewardess;
    }

    public void setStewardess(int stewardess) {
        this.stewardess = stewardess;
    }
}

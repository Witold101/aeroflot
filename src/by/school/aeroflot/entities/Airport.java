package by.school.aeroflot.entities;

public class Airport {
    private long id;
    private String name;
    private boolean flyingWeather;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlyingWeather() {
        return flyingWeather;
    }

    public void setFlyingWeather(boolean flyingWeather) {
        this.flyingWeather = flyingWeather;
    }
}

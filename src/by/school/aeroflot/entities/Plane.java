package by.school.aeroflot.entities;

public class Plane {
    private Long id;
    private String model;
    private int capacity;
    private int flyingRange;
    private Long flyListId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFlyingRange() {
        return flyingRange;
    }

    public void setFlyingRange(int flyingRange) {
        this.flyingRange = flyingRange;
    }

    public Long getFlyListId() {
        return flyListId;
    }

    public void setFlyListId(Long flyListId) {
        this.flyListId = flyListId;
    }
}

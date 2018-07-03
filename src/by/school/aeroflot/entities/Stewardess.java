package by.school.aeroflot.entities;

public class Stewardess extends Person {
    private Long flyListId;

    public Long getFlyListId() {
        return flyListId;
    }

    public void setFlyListId(Long flyListId) {
        this.flyListId = flyListId;
    }
}

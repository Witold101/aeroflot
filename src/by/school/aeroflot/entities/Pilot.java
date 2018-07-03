package by.school.aeroflot.entities;

import by.school.aeroflot.entities.Person;

public class Pilot extends Person {
    private Long flyListId;

    public Long getFlyListId() {
        return flyListId;
    }

    public void setFlyListId(Long flyListId) {
        this.flyListId = flyListId;
    }
}


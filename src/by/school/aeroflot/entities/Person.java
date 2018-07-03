/**
 * Родительский класс для для всех людей
 */

package by.school.aeroflot.entities;

public class Person {
    private long id;
    private String name;
    private String lastName;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

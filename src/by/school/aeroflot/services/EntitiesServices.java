package by.school.aeroflot.services;

import java.sql.SQLException;

public interface EntitiesServices<E, K> {
    E save(E t);
    E get(K id);
    void update(E t);
    void delete(K id);
}
package by.school.aeroflot.dao;

import java.sql.SQLException;

public interface DAO<T, K> {
    T save(T t) throws SQLException;
    T get(K id) throws SQLException;
    void update(T t) throws SQLException;
    void delete(K id) throws SQLException;
}

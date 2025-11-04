package com.desigveloper.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
    Optional<T> get(String t);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}

package com.desigveloper.studentmanagement.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
    Optional<T> get(String id);
    List<T> getAll();
    void create(T t);
    void update(T t);
    void delete(T t);
}
